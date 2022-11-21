package Class18;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {
    
    static WebDriver driver;

    public static void main(String[] args) {
        
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        
        driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
        By emailId = By.id("input-email");
        
        waitForElementPresentUsingFluentWait(emailId, 10, 2).sendKeys("pravin@gmail.com");
    }
    
    public static WebElement waitForElementPresentUsingFluentWait(By locator, int timeout, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Element is not found...");
        
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    
    public static WebElement waitForElementPresentUsingWebDriverWait(By locator, int timeout, int pollingTime) {
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.withTimeout(Duration.ofSeconds(timeout))
        .pollingEvery(Duration.ofSeconds(pollingTime))
        .ignoring(NoSuchElementException.class)
        .ignoring(StaleElementReferenceException.class)
        .withMessage("Element is not found...");
        
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator)); 
    }

}
