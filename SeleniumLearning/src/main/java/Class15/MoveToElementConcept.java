package Class15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementConcept {

    static WebDriver driver;
    
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        try {
            driver.get("http://mrbool.com/search/?txtsearch=how+to+create+menu+with+submenu+using+css");
            By contentMenu = By.className("menulink");
            By courseLink = By.linkText("COURSES");
            By articlesLink = By.linkText("ARTICLES");
            doClickOnChildMenu(contentMenu, courseLink);
            Thread.sleep(3000);
            doClickOnChildMenu(contentMenu, articlesLink);
            
        } finally {
            driver.quit();
        }
    }
    
    public static WebElement getElement(By locator) {
        return driver.findElement(locator);
    }
    
    public static void doMoveToElement(By locator) {
        Actions act = new Actions(driver);
        act.moveToElement(getElement(locator)).perform();
    }
    
    public static void doClickOnChildMenu(By parentMenuLocator, By childMenuLocator) throws InterruptedException {
        doMoveToElement(parentMenuLocator);
        Thread.sleep(3000);
        getElement(childMenuLocator).click();
    }

}
