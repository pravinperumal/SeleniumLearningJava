package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownWithoutUsingSelectMethods {

    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
        By country = By.xpath("//select[@id='Form_getForm_Country']/option");
        SelectDropDownWithoutUsingSelect(country, "Chile");
        Thread.sleep(5000);
        driver.close();
    }

    public static List<WebElement> getElements(By locator) {
        List<WebElement> elements = driver.findElements(locator);            
        return elements;		
    }

    public static void SelectDropDownWithoutUsingSelect(By locator, String value){
        List<WebElement> elementList = getElements(locator);
        System.out.println(elementList.size());
        for (WebElement e : elementList) {
            String text = e.getText();
            System.out.println(text);
            if(text.equals(value)){
                e.click();
                break;
            }
        }
    }

     
    
}
