package MtsTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class MtsOnlinePaymentTest {
    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    @Test
    public void testOnlineTopUpBlock() {
        driver.get("https://www.mts.by/");
        // Закрываем баннер куки
        try {
            WebElement cookieBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("cookie-agree")));
            cookieBtn.click();
            wait.until(ExpectedConditions.invisibilityOf(cookieBtn));
        } catch (TimeoutException ignored) {}
        // Скроллим к блоку "Онлайн пополнение без комиссии"
        WebElement block = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("div.pay__wrapper")));
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", block);
        // Проверяем заголовок
        WebElement heading = block.findElement(By.tagName("h2"));
        String headerText = heading.getText().replace("\n", " ");
        Assert.assertTrue(headerText.contains("Онлайн пополнение") &&
                        headerText.contains("без комиссии"),
                "Заголовок блока неверен");
        // Проверяем наличие 5 логотипов
        List<WebElement> logos = block.findElements(
                By.cssSelector("div.pay__partners ul li img"));
        Assert.assertEquals(logos.size(), 5, "Ожидается 5 логотипов платежных систем");
        // Проверяем работу ссылки "Подробнее о сервисе"
        WebElement more = block.findElement(By.linkText("Подробнее о сервисе"));
        wait.until(ExpectedConditions.elementToBeClickable(more)).click();
        wait.until(ExpectedConditions.urlContains("poryadok-oplaty"));
        Assert.assertTrue(driver.getCurrentUrl()
                        .contains("poryadok-oplaty"),
                "Ссылка 'Подробнее о сервисе' не открылась");
        // Возвращаемся на главную страницу
        driver.navigate().back();
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("div.pay__wrapper")));
        // Заполняем форму «Услуги связи»
        WebElement form = driver.findElement(By.id("pay-connection"));
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", form);
        driver.findElement(By.id("connection-phone")).sendKeys("297777777");
        driver.findElement(By.id("connection-sum")).sendKeys("10");
        // Нажимаем "Продолжить"
        WebElement continueBtn = form.findElement(
                By.cssSelector("button[type='submit']"));
        Assert.assertTrue(continueBtn.isDisplayed() && continueBtn.isEnabled(),
                "Кнопка 'Продолжить' недоступна");
        continueBtn.click();
        // Переключаемся в iframe оплаты
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("iframe.bepaid-iframe[src*='checkout.bepaid.by']")));
        driver.switchTo().frame(iframe);
        // Возвращаемся в основной контекст
        driver.switchTo().defaultContent();
    }
    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
