package Class20;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class PaginationConcept {

    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        driver.manage().window().maximize();
        driver = new EdgeDriver();
        driver.get("https://classic.crmpro.com/index.html");

        driver.findElement(By.name("username")).sendKeys("newautomation");
        driver.findElement(By.name("password")).sendKeys("Selenium@12345");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Thread.sleep(5000);

        driver.switchTo().frame("mainpanel");
        driver.findElement(By.linkText("CONTACTS")).click();

        Thread.sleep(5000);
        driver.quit();
    }
}
