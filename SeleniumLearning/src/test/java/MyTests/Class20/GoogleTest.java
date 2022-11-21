package MyTests.Class20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest {
    
 WebDriver driver;
    
    @Test(priority = 1)
    public void cookiesPrompt() {
        driver.get("https://www.google.com/");
        boolean isPromptDisplayed = driver.findElement(By.id("W0wltc")).isDisplayed();
        driver.findElement(By.id("W0wltc")).click();
        Assert.assertTrue(isPromptDisplayed);
    }
    
    @Test(priority = 2)
    public void searchTest() {
        boolean flag = driver.findElement(By.name("q")).isDisplayed();
        Assert.assertTrue(flag);
    }
    
    @Test(priority = 2)
    public void googleSearchBtnTest() {
        boolean flag = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]")).isDisplayed();
        Assert.assertTrue(flag);
    }
    
    @Test(priority = 2)
    public void urlTest() {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("google"));
    }

}
