package class12;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import SeleniumSessions.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class staticWebTableHandle {
    
    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        ElementUtil el = new ElementUtil(driver);
        
        try {
            driver.get("https://www.w3schools.com/html/html_tables.asp");
            By rowLocator = By.xpath("//*[@id='customers']/tbody/tr");
            By columnLocator = By.xpath("//*[@id='customers']/tbody/tr[1]/th");
            String beforeXpath = "//*[@id='customers']/tbody/tr[";
            String afterXpath ="]/td[";
            el.printTable(rowLocator, columnLocator, beforeXpath, afterXpath);
  
        } catch(Exception e) {
            System.out.println("#######################################An Exception Occured#######################################");
            System.out.println("The following error occured: "+e.getMessage());;
//          e.printStackTrace();
            System.out.println("##################################################################################################");
        }
        
        finally {
            driver.quit();
        }
   }
    
    
}
