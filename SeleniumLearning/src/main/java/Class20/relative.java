package Class20;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.time.Duration;

public class relative {

    static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            driver.get("http://www.whenwise.com/sign-in/");

            driver.findElement(By.id("email")).sendKeys("naveenanimation20@gmail.com");
            driver.findElement(By.id("password")).sendKeys("Test@12345");
            driver.findElement(By.id("login-btn")).click();
            driver.navigate().to("https://whenwise.com/users/2835/edit");

            WebElement ele = driver.findElement(By.xpath("//span[text()='Email on booking confirmation?']"));
            driver.findElement(with(By.className("lever")).toRightOf(ele)).click();

        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            driver.quit();
        }
    }
}
