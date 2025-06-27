package MtsTests;

import pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class MtsOnlinePayment2Test {
    private WebDriver driver;
    private WebDriverWait wait;
    private MainPage mainPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        mainPage = new MainPage(driver, wait);
    }

    @Test
    public void testEmptyFieldsValidation() {
        mainPage.open();
        mainPage.acceptCookies();
        List<String> services = Arrays.asList("Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность");
        for (String service : services) {
            mainPage.selectPaymentService(service);
            mainPage.submitCurrentPaymentForm();
            List<String> messages = mainPage.getValidationMessagesFromActiveForm();
            for (String msg : messages) {
                Assert.assertEquals(msg, "Заполните это поле", "Validation message mismatch for: " + service);
            }
        }
    }

    @Test
    public void testConnectionServicePayment() {
        mainPage.selectPaymentService("Услуги связи");
        mainPage.fillConnectionForm("297777777", "10");
        mainPage.submitCurrentPaymentForm();
        Assert.assertTrue(mainPage.isPaymentIframePresent(), "Окно оплаты не появилось");
        Assert.assertTrue(mainPage.verifyIframeContent("297777777", "10"), "Содержимое iframe не соответствует ожиданиям");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
