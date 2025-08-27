package reeloasg;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ReeloAssignment {

    private static WebDriver driver;
    private static WebDriverWait wait;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            driver.manage().window().maximize();

            // STEP 1: Open login page
            driver.get("https://dev.reelo.io/login");

            // STEP 2: Login
            typeText(By.name("email"), "shubhamchavan5115@gmail.com");
            typeText(By.name("password"), "Shubham@123");
            clickElement(By.xpath("//span[@class='button-text']"));

            // STEP 3: Go to Campaigns
            clickElement(By.xpath("//span[normalize-space()='Campaigns']"));

            // STEP 4: Select template
            WebElement template = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//h4[normalize-space()='Celebrate Onam with a Grand Feast']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", template);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", template);

            // STEP 5: Select SMS channel
            clickJS(By.xpath("//div[normalize-space()='SMS']"));

            // STEP 6: Click "Customise and Send"
            clickElement(By.xpath("//span[normalize-space()='Customise and Send']"));

            // STEP 7: Click Next on channel selection
            clickElement(By.xpath("//button[normalize-space()='Next']"));

            // STEP 8: Set campaign title
            typeText(By.xpath("//input[@placeholder='Enter Title']"), "My Test Campaign");
            clickElement(By.xpath("//button[contains(text(),'Next')]"));

            // STEP 9: Audience page - Click Next
            clickElement(By.xpath("//button[contains(text(),'Next')]"));

            // STEP 10: Trigger page - Click Next
            clickElement(By.xpath("//button[contains(text(),'Next')]"));

            // STEP 11: Modify SMS content
            WebElement smsContent = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//span[normalize-space()='Enjoy! This Onam']")));
            smsContent.clear();
            smsContent.sendKeys("Hello, this is Shubham testing Reelo automation.");
            clickElement(By.xpath("//button[contains(text(),'Next')]"));
            
            clickElement(By.xpath("//button[contains(text(),'Next')]"));

            
            
            
            // STEP 12: Test campaign
            clickElement(By.xpath("//span[normalize-space()='Test campaign']"));

            
            Thread.sleep(5000);
            // STEP 13: Save & Exit
            clickElement(By.xpath("//button[normalize-space()='Save and exit']"));
            Thread.sleep(5000);

            System.out.println(" Assignment workflow completed successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }


    private static void clickElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    private static void clickJS(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    private static void typeText(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }
}
