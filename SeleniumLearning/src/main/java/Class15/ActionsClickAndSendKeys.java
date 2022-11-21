package Class15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClickAndSendKeys {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://demo.opencart.com/index.php?route=account/register");

        By firstName = By.name("firstname");
        By lastName = By.name("lastname");
        By agree = By.name("agree");
        doActionSendKeys(firstName, "Pravin");
        doActionSendKeysOnActiveElement(lastName, "Perumal");
        Thread.sleep(3000);

    }

    public static WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public static void doActionSendKeys(By locator, String value) {
        Actions action = new Actions(driver);
        action.sendKeys(getElement(locator), value).build().perform();
    }

    public static void doActionSendKeysOnActiveElement(By locator, String value) {
        Actions action = new Actions(driver);
        action.click(getElement(locator)).sendKeys(value).build().perform();
    }
    
    public static void doActionClick(By locator) {
        Actions action = new Actions(driver);
        action.click(getElement(locator)).build().perform();
    }
    
    public static void doActionMoveToElementClick(By locator) {
        Actions action = new Actions(driver);
        action.moveToElement(getElement(locator)).click().build().perform();
    }

}
