package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import java.lang.Thread;
import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoSuchElementConcept {
 
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.orangehrm.com/orangehrm-30-day-trial");
        
        WebElement firstName = driver.findElement(By.id("Form_getForm_Name"));
        firstName.sendKeys("Pravin");
        
        List<WebElement> list = driver.findElements(By.className("text"));
        
        driver.close();        
    }

    public static void ifElementExist(By locator){
        int elementCount = driver.findElements(locator).size();
        System.out.println("Total elements found: "+elementCount);
        if (elementCount >= 1) {
            System.out.println("Element is found. "+locator);
        }
        else{
            System.out.println("Element is not found..."+locator);
        }
    }
}
