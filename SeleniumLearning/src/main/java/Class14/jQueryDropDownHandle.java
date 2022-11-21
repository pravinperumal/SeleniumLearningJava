package Class14;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jQueryDropDownHandle {
    
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        
        try {
            driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
            Thread.sleep(3000);    
            
            driver.findElement(By.id("justAnInputBox")).click();            
            By locator = By.cssSelector("span.comboTreeItemTitle");
//            String value = "choice 6 2 1";   
            selectChoice(locator, "choice 3", "choice 45");
//            selectChoice(locator, "choice 3", "choice 4", "choice 7", "choice 6 2 3");
//            selectChoice(locator,"all");
//            selectChoice(locator, value);
            
            
        } catch (Exception e) {
            System.out.println("##############################Exception Occured##############################");
            System.out.println(e.getClass());
            e.printStackTrace();
            System.out.println("##############################################################################");
        
        } finally {
            System.out.println("The process has finished.");
            driver.quit();
        }
    }
    
    public static void selectChoice(By locator, String... value) throws InterruptedException{
        
        List<WebElement> choicesList = driver.findElements(locator);
        boolean elementAvailable = true;
        if(!value[0].equals("all")) {            
            for(WebElement e:choicesList) {            
                for (int i = 0; i < value.length; i++) {
                    if(e.getText().equals(value[i])) {
                        e.click(); 
                        break;
                    }
                    else {
                        elementAvailable = false;
                    }
                }                       
            }
            Thread.sleep(3000);
        }
        else {
            try {
                for(WebElement e:choicesList) {
                    if(e.getText().isBlank() || e.getText().isEmpty() || !e.isEnabled()) {}
                    else
                        e.click();
                }                   
                Thread.sleep(3000);
            } catch (ElementNotInteractableException e) {
                System.out.println("all choices are over.");
            }
        }
        
        if(elementAvailable == false) {
            System.out.println("Incorrect element. The element was not found.");
        }
    }
}
