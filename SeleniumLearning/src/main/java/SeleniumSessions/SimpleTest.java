package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);
        driver.findElement(By.name("username")).sendKeys("Admin");        
        System.out.println(driver.getTitle());
        System.out.println("Closing page after checking");
        driver.close();
    }

}
