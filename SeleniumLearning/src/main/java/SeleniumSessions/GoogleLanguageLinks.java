package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleLanguageLinks {

    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bing.com/?cc=in");       
        By langLinks = By.xpath("//div[@class='switch_lang']/a");
        Thread.sleep(10000);
        List<String> actualLinksTextList = getLinksTextList(langLinks);
        if(actualLinksTextList.contains("हिंदी")) {
        	System.out.println("हिंदी is present in the page.");
        }
        Thread.sleep(10000);
        driver.quit();
    }
    
    public static List<String> getLinksTextList(By locator) {
    	List<WebElement> linksList = driver.findElements(locator);
    	List<String> linksTextList = new ArrayList<String>();
        System.out.println(linksList.size());
        for (WebElement e : linksList) {
        	String text = e.getText().trim();
        	linksTextList.add(text);
        }
        return linksTextList;
    }
    
    public static void clickOnElement(By locator, String linkText) throws InterruptedException {
    	List<WebElement> langList = driver.findElements(locator);
    	System.out.println(langList.size());
        for (WebElement e : langList) {
        	String text = e.getText().trim();
            if(text.equals(linkText)) {
            	e.click();
            }                    
        }
    }    
}
