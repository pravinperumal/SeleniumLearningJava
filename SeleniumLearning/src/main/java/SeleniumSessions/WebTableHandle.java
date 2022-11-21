package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandle {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--inprivate");
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();

        try {
            login();

            Thread.sleep(5000);
            driver.switchTo().frame("mainpanel");
            driver.findElement(By.xpath("//*[@title='Contacts']")).click();
            // selectContact("deepti gupta");
            selectContact("Romi singh");
            System.out.println(getCompanyName("Romi singh"));
            System.out.println(getPhoneNumber("Romi singh"));
            System.out.println(getEmailAddress("Romi singh"));
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Process finished");
            driver.close();
        }
    }

    public static void selectContact(String contactName){
        String xpath = "//a[text()='"+contactName+"']/parent::td/preceding-sibling::td/input[@name='contact_id']";
        driver.findElement(By.xpath(xpath)).click();
    }

    public static String getCompanyName(String contactName){
        String xpath = "//a[text()='"+contactName+"']/parent::td/following-sibling::td/a[@context='company']";
        return driver.findElement(By.xpath(xpath)).getText();
    }

    public static List<String> getPhoneNumber(String contactName){
        String xpath = "//a[text()='"+contactName+"']/parent::td/following-sibling::td/span[@context='phone']";                        
        List<WebElement> phoneListWebElement = driver.findElements(By.xpath(xpath));
        List<String> phoneNumbersList = new ArrayList<String>();
        for (WebElement e : phoneListWebElement) {
            phoneNumbersList.add(e.getText());
        }
        return phoneNumbersList;
    }

    public static String getEmailAddress(String contactName){
        String xpath = "//a[text()='"+contactName+"']/parent::td/following-sibling::td//a[text()[contains(.,'@')]]";
        return driver.findElement(By.xpath(xpath)).getText();
    }
    //a[text()='Romi singh']/parent::td/following-sibling::td/following-sibling::td//a[text()[contains(.,'@')]]

    public static void login() {
        driver.get("https://classic.crmpro.com/index.html");
        driver.findElement(By.name("username")).sendKeys("newautomation");
        driver.findElement(By.name("password")).sendKeys("Selenium@12345");
        driver.findElement(By.className("input-group-btn")).click();
    }

    // public static void selectContact(String contactName){
    // String xpath =
    // "//a[text()='"+contactName+"']+parent::td/preceding-sibling::td/input";
    // }

}
