package MyTests.Class20;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest {
    
    WebDriver driver;
    
    @BeforeTest
    public void setup() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.google.com/");      
    }
    
    @Test
    public void cookiesPrompt() {
        boolean isPromptDisplayed = driver.findElement(By.id("W0wltc")).isDisplayed();
        driver.findElement(By.id("W0wltc")).click();
        Assert.assertTrue(isPromptDisplayed);
    }
    
    @Test
    public void searchTest() {
        boolean flag = driver.findElement(By.name("q")).isDisplayed();
        Assert.assertTrue(flag);
    }
    
    @Test
    public void googleSearchBtnTest() {
        boolean flag = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]")).isDisplayed();
        Assert.assertTrue(flag);
    }
    
    @Test
    public void urlTest() {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("google"));
    }
    
    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
