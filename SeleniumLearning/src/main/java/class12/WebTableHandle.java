package class12;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandle {
    
    static WebDriver driver;
    
    public static void main(String[] args) throws InterruptedException, NoSuchElementException {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        
        try {
            driver.get("https://classic.freecrm.com/index.html");
            driver.findElement(By.name("username")).sendKeys("newautomation");
            driver.findElement(By.name("password")).sendKeys("Selenium@12345");
            driver.findElement(By.xpath("//input[@value='Login']")).click();
            Thread.sleep(5000);
            driver.switchTo().frame("mainpanel");
            driver.findElement(By.linkText("CONTACTS")).click();
            
            selectContact("deepti gupta");
            selectContact("Romi singh");
            System.out.println("The company name for contact: Romi Singh is:  "+getCompanyName("deepti gupta"));
            Thread.sleep(5000);
            int count = 1;
            List<String> phoneList = getContactPhoneList("Romi singh");
            System.out.println(phoneList);
            System.out.println(getEmailAddress("deepti gupta"));
//            for (String e:phoneList) {                
//                if(e.strip().isBlank() || e.strip().isEmpty() || e == null) {
//                    System.out.println("The phone number is empty");
//                }
//                else
//                    System.out.println(count+" "+e.length()+"  "+e);
//                count++;
//            }
            driver.quit();
            
        } catch (Exception e) {
            System.out.println("################################################Exception Occured################################################");
            System.out.println("The following exception occured: "+e.getClass().getName());
            System.out.println(e.getMessage());
            System.out.println("################################################Exception Occured################################################");
            
        } finally {
            driver.quit();
        }
    
    }

    public static void selectContact(String contactName) {
        String xpath = "//a[text()='"+contactName+"']/parent::td/parent::tr//input[@name='contact_id']";
        driver.findElement(By.xpath(xpath)).click();
    }
    
    public static String getCompanyName(String contactName) {
        String xpath = "//a[text()='"+contactName+"']/parent::td/parent::tr//a[@context='company']";
        return driver.findElement(By.xpath(xpath)).getText();
    }
    
    public static List<String> getContactPhoneList(String contactName) {
        String xpath = "//a[text()='"+contactName+"']/parent::td/parent::tr//span[@context='phone']";
        List<WebElement> phoneNumbersList = driver.findElements(By.xpath(xpath));
        List<String> listOfPhoneNumbers = new ArrayList<String>();
        for (WebElement phNo : phoneNumbersList) {
            listOfPhoneNumbers.add(phNo.getText());
        }
        return listOfPhoneNumbers;
    }
    
    public static String getEmailAddress(String contactName) {
        String xpath = "//a[text()='"+contactName+"']/parent::td/parent::tr//a[contains(text(),'@')]";
        return driver.findElement(By.xpath(xpath)).getText();
    }
}
