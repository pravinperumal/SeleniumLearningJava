package Class18;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWait {
    
    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        
        try {
            driver.get("https://demo.opencart.com/index.php?route=account/login");
            By emailID = By.id("input-email");
            retryingElement(emailID, 10, 500).sendKeys("pravin");
            driver.quit();
        } catch (Exception e) {            
            e.printStackTrace();
        }
    }
    
    public static WebElement getElement(By locator) {
        return driver.findElement(locator);
    }
    
    public static WebElement retryingElement(By locator, int timeout, long pollingTime){
        WebElement element = null;
        int attempts = 0;
        
        while (attempts < timeout) {
            try {
                element = getElement(locator);
                break;
            } catch (NoSuchElementException e) {
                System.out.println("The element is not found in attempt: "+attempts+" : "+locator);
                attempts++;
                try {
                    Thread.sleep(pollingTime);
                } catch (InterruptedException e1) {                    
                    e1.printStackTrace();
                }
            }            
        } 
        
        if(element == null) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Element is not found exception... tried for : " + timeout +
                        " with the interval of : "+ attempts);
            }
        }
        return element;
    }
    
    public static WebElement retryingElement(By locator, int timeout){
        WebElement element = null;
        int attempts = 0;
        
        while (attempts < timeout) {
            try {
                element = getElement(locator);
                break;
            } catch (NoSuchElementException e) {
                System.out.println("The element is not found in attempt: "+attempts+" : "+locator);
                attempts++;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e1) {                    
                    e1.printStackTrace();
                }
            }            
        } 
        
        if(element == null) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Element is not found exception... tried for : " + timeout +
                        " with the interval of : "+ attempts);
            }
        }
        return element;
    }
    
    

}
