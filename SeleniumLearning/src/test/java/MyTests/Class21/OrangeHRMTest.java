package MyTests.Class21;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMTest extends BaseTest {

    @Test
    public void contactSalesTest() {
        boolean flag = driver.findElement(By.linkText("Contact Sales")).isDisplayed();
        Assert.assertTrue(flag);
    }
    
    @Test
    public void urlTest() {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("orangehrm"));
    }

}
