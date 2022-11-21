package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import SeleniumSessions.ElementUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorConcept {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		EdgeOptions edOpt = new EdgeOptions();
		edOpt.addArguments("-inprivate");
		driver = new EdgeDriver(edOpt);
		String url = "https://demo.opencart.com/index.php?route=account/login&language=en-gb";
		
		driver.get(url);
		
//		WebElement emailAddress = driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
//		
//		emailAddress.sendKeys("test@gmail.com");
//		password.sendKeys("test@gmail.com");
		
		By username = By.id("input-email");
		By password = By.id("input-password");
		
//		WebElement emailAddress = driver.findElement(username);
//		WebElement usrPassword = driver.findElement(password);
//		
//		emailAddress.sendKeys("test@gmail.com");
//		usrPassword.sendKeys("test@gmail.com");
		
//		doSendKeys(username,"test@gmail.com");
//		doSendKeys(password, "dfjlksda");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(username, "test@gmail.com");
		eleUtil.doSendKeys(password, "123456");
	}
	
	
	
	
//	public static WebElement getElement(By locator) {
//		return driver.findElement(locator);
//	}
//	
//	public static void doSendKeys(By locator, String value) {
//		getElement(locator).sendKeys(value);
//	}

}
