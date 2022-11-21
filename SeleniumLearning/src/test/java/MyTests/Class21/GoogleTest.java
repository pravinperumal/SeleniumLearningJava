package MyTests.Class21;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest{
    
    @Test(priority = 1)
    public void cookiesPrompt() {
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
