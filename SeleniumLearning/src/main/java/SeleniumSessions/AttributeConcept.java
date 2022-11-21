package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AttributeConcept {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		 WebDriverManager.edgedriver().setup();
		 driver = new EdgeDriver();
		 driver.get("https://www.amazon.com");
		 
		 By amazonDevicesLink = By.linkText("Amazon Devices");
		 String hrefVal = getAttributeValue(amazonDevicesLink, "href");
		 
		 if(hrefVal.contains("footer_devices")) {
			 System.out.println("Correct value");
		 }
		 driver.quit();
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static String getAttributeValue(By locator, String attrName) {
		String attValue = getElement(locator).getAttribute(attrName);
		System.out.println(attValue);
		return attValue;
	}

}
