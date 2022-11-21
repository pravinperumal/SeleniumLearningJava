package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {

    static WebDriver driver;
    
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//*[@id='W0wltc']/div")).click();
        driver.findElement(By.name("q")).sendKeys("t");
        Thread.sleep(5000);
        driver.findElement(By.name("q")).sendKeys("est ");
        Thread.sleep(5000);
        List<WebElement> optionsDisplayed = 
        driver.findElements(By.xpath("//*[@role='option']"));
        for (WebElement webElement : optionsDisplayed) {
            System.out.println(webElement.getText());
        }
        driver.close();
    }
    
}
