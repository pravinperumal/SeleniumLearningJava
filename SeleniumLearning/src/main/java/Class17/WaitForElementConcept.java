package Class17;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForElementConcept {

    static WebDriver driver;
    
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
//        driver.get("https://classic.crmpro.com/index.html");
        driver.get("https://www.freshworks.com/");
        
        try {
            By username = By.name("username1");
            By password = By.name("password");
            By loginBtn = By.xpath("//input[@type='submit']");
            
//            doSendKeys(username, "pravin", 10);
            doPresenceOfElementLocated(username, 10, 2000);
                       
//            doPresenceOfElementLocated(username, 10).sendKeys("pravin");
//            driver.findElement(password).sendKeys("pravin");
//            driver.findElement(loginBtn).click();
            
            By footers = By.xpath("//div[@class=\'col-sm-6\']//ul/li");
            List<WebElement> footerList = waitForElementsToBeVisible(footers, 5);
            
           if(getElementsTextListWithWait(footers, 10).contains("partners")) {
               System.out.println("The test has passed.");
           }
        } catch (Exception e) {
            
            System.out.println("######################################################Exception Occured######################################################");
            e.printStackTrace();
            System.out.println("######################################################Exception Details End######################################################");
        
        } finally {            
            driver.quit();
            System.out.println("The test has finished");            
        }
        
    }
    
    public static void doSendKeys(By locator, String value, int timeout) {
        doPresenceOfElementLocated(locator, timeout).sendKeys(value);
    }
    
    public static WebElement doPresenceOfElementLocated(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    
    public static WebElement doPresenceOfElementLocated(By locator, int timeout, long intervalTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout), Duration.ofMillis(intervalTime));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    
    public static WebElement waitForElementToBeVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public static WebElement waitForElementToBeVisible(By locator, int timeout, long intervalTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(intervalTime));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public static List<WebElement> waitForElementsToBeVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    
    public static List<WebElement> waitForElementsToBeVisible(By locator, int timeout, long intervalTime){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout), Duration.ofMillis(intervalTime));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    
    public static List<String> getElementsTextListWithWait(By locator, int timeout) {
        List<WebElement> eleList = waitForElementsToBeVisible(locator, timeout);
        List<String> eleListText = new ArrayList<String>();
        for (WebElement webEle : eleList) {
            String text = webEle.getText();
            eleListText.add(text);            
        }
        return eleListText;
    }  
    
    public static List<String> getElementsTextListWithWait(By locator, int timeout, long intervalTime) {
        List<WebElement> eleList = waitForElementsToBeVisible(locator, timeout, intervalTime);
        List<String> eleListText = new ArrayList<String>();
        for (WebElement webEle : eleList) {
            String text = webEle.getText();
            eleListText.add(text);            
        }
        return eleListText;
    }
    
    
}
