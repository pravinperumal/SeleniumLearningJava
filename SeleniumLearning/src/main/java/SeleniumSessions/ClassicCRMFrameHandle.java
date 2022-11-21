package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassicCRMFrameHandle {

    public static void main(String[] args) throws InterruptedException {
            WebDriverManager.edgedriver().setup();
            WebDriver driver = new EdgeDriver();
            driver.manage().window().maximize();

            driver.get("https://www.crmpro.com/index.html");
           
            driver.findElement(By.name("username")).sendKeys("newautomation");
            driver.findElement(By.name("password")).sendKeys("Selenium@12345");
            driver.findElement(By.xpath("//input[@value='Login']")).click();
            Thread.sleep(5000);
            
            driver.switchTo().frame("mainpanel").findElement(By.linkText("CONTACTS")).click();
            Thread.sleep(5000);
            
            driver.switchTo().defaultContent();
            driver.switchTo().parentFrame();
            driver.close();
        }
    }
    

