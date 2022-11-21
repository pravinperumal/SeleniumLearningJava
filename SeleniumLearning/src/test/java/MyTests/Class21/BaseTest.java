package MyTests.Class21;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;

    @Parameters({"url", "browser"})
    @BeforeTest
    public void setup(String url, String browser) {
        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if(browser.equals("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            System.out.println("Please pass the right browser name.");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
