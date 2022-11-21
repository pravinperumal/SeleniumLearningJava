package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksTextUtil {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://www.amazon.co.uk");
		By locator = By.tagName("img");
		int count = getElementsCount(locator);
		System.out.println(count);
		driver.quit();
	}
	
	public static int getElementsCount(By locator) {
		return getElements(locator).size();
	}	
	
	public static List<WebElement> getElements(By locator) {
        List<WebElement> elements = driver.findElements(locator);            
        return elements;		
    }
}
