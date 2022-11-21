package Class17;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForNonWebElements {
    
    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        
        driver.get("https://automationpractice.com/index.php");
        driver.findElement(By.linkText("Contact us")).click();
        
        if(waitForURLToContain("controller=contact", 10)) {
            System.out.println("URL is correct.");
        }
        String title = doGetTitle("Contact us - My Store", 10);
        System.out.println(title);
        driver.quit();
    }
    
    public static String getTitle() {
        return driver.getTitle();
    }
    
    public static String doGetTitleWithFraction(String titleFraction, int timeout) {
        if(waitForTitleContains(titleFraction, timeout))
            return driver.getTitle();
        return null;
    }
    
    public static String doGetTitle(String titleFraction, int timeout) {
        if(waitForTitleToBe(titleFraction, timeout))
            return driver.getTitle();
        return null;
    }
    
    public static boolean waitForTitleContains(String titleFraction, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.titleContains(titleFraction));
    }
    
    public static boolean waitForTitleToBe(String titleFraction, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.titleIs(titleFraction));
    }
    
    public static boolean waitForURLToContain(String urlFraction, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.urlContains(urlFraction));
    }
    
    public static boolean waitForURLToBe(String url, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.urlToBe(url));
    }

}
