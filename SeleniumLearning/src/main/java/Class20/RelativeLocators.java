package Class20;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import java.time.Duration;

public class RelativeLocators {

    static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.aqi.in/dashboard/canada");

        WebElement ele = driver.findElement(By.linkText("Port Alberni, Canada"));

        String aqi_us = driver.findElement(with(By.tagName("p")).toRightOf(ele)).getText();
        System.out.println(aqi_us);

        String rank = driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
        System.out.println(rank+" "+"Port Alberni, Canada"+" "+aqi_us);

        driver.quit();
    }
}
