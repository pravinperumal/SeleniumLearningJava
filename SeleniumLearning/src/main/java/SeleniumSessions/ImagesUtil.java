package SeleniumSessions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class ImagesUtil {
	
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://www.msn.co.uk");
		
		By images = By.tagName("img");
		By links = By.tagName("a");
		
		printElementValues(getAttributeList(images, "alt"));
		printElementValues(getAttributeList(links, "alt"));
		driver.quit();
	}
	
	public static int getElementsCount(By locator) {
		return getElements(locator).size();
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static void printElementValues(List<String> eleList) {
		for(String e: eleList) {
			System.out.println(e);
		}
	}
	
	public static List<String> getAttributeList(By locator, String attributeName) {
		List<WebElement> eleList = new ArrayList<WebElement>();
		List<String> attrList = new ArrayList<String>();
		for (WebElement e: eleList) {	
			String attrValue = e.getAttribute(attributeName);
			attrList.add(attrValue);
		}
		return attrList;
	}

}
