package Class16;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitlyWaitConcept {
    
    static WebDriver driver;
    
    public static void main(String[] args) {
        
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        
        try {
            driver.get("https://classic.crmpro.com/index.html");
            driver.findElement(By.name("username")).sendKeys("pravin");
            driver.findElement(By.name("password")).sendKeys("password");
            driver.findElement(By.xpath("//input[@value='Login']")).click();
            
        } catch (Exception e) {
            System.out.println("\n\n##############################Exception Occured##############################");            
            System.out.println("The exception message is: "+e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
        
        
    }

}
