package Class15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropConcept {
    
    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
        
        try {
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        
        Actions act = new Actions(driver);
//        act.clickAndHold(source).moveToElement(target).release().build().perform();
        act.dragAndDrop(source, target).perform();
        
        } catch (Exception e) {
            System.out.println("####################Exception Occured####################");
            System.out.println(e.getMessage().toString());
            System.out.println(e.getClass().toString());
            System.out.println("####################Exception Details####################");
            
        } finally {
            driver.quit();
        }
       
    }

}
