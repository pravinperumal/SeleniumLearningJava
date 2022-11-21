package Class18;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickWhenReady {
    
    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();        
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/index.php?route=account/login");
        
        By register = By.linkText("Register");
        clickElementWhenReady(register, 5);
        
    }

    public static void clickElementWhenReady(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    
    public static void clickElementWhenReady(By locator, int timeout, long intervalTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout), Duration.ofMillis(intervalTime));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
}
