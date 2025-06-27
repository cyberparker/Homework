package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open() {
        driver.get("https://www.mts.by/");
    }

    public void acceptCookies() {
        try {
            WebElement cookieBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
            cookieBtn.click();
            wait.until(ExpectedConditions.invisibilityOf(cookieBtn));
        } catch (TimeoutException ignored) {}
    }

    public void selectPaymentService(String serviceName) {
        WebElement dropdownBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.select__header")));
        dropdownBtn.click();
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("ul.select__list li")));
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(serviceName)) {
                option.click();
                break;
            }
        }
    }

    public void fillConnectionForm(String phone, String amount) {
        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("connection-phone")));
        WebElement sumInput = driver.findElement(By.id("connection-sum"));
        phoneInput.clear();
        phoneInput.sendKeys(phone);
        sumInput.clear();
        sumInput.sendKeys(amount);
    }

    public void submitCurrentPaymentForm() {
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("form button[type='submit']")));
        submitBtn.click();
    }

    public List<String> getValidationMessagesFromActiveForm() {
        List<String> messages = new ArrayList<>();
        List<WebElement> inputs = driver.findElements(By.cssSelector("form input:required"));
        for (WebElement input : inputs) {
            if (input.getAttribute("value").isEmpty()) {
                try {
                    String msg = (String) ((JavascriptExecutor) driver).executeScript(
                            "return arguments[0].validationMessage;", input);
                    messages.add(msg);
                } catch (Exception e) {
                    messages.add("Error reading message");
                }
            }
        }
        return messages;
    }

    public boolean isPaymentIframePresent() {
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe.bepaid-iframe[src*='checkout.bepaid.by']")));
            return true;
        } catch (TimeoutException e) {
            return false;
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    public boolean verifyIframeContent(String expectedPhone, String expectedAmount) {
        try {
            WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe.bepaid-iframe[src*='checkout.bepaid.by']")));
            driver.switchTo().frame(iframe);

            boolean phoneOk = driver.getPageSource().contains(expectedPhone);
            boolean amountOk = driver.getPageSource().contains(expectedAmount);
            boolean cardIconsOk = driver.findElements(By.cssSelector("img[src*='visa'], img[src*='mastercard']")).size() > 0;
            return phoneOk && amountOk && cardIconsOk;
        } catch (Exception e) {
            return false;
        } finally {
            driver.switchTo().defaultContent();
        }
    }
}