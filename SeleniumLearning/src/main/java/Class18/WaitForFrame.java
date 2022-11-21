package Class18;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForFrame {

    static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("http://londonfreelance.org/courses/frames/index.html");

        String header = driver.findElement(By.xpath("/html/body/h2")).getText();
        System.out.println(header);
        driver.quit();
    }
    
    public static void waitForFrameByNameOrID(String nameOrID, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrID));      
    }
    
    public static void waitForFrameByLocator(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));        
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }
    
    public static void waitForFrameByIndex(int frameIndex, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));    
    }
    
    public static void waitForFrameByElement(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

}
