package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OtherLocators {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://classic.crmpro.com/index.html");
			
		By emailId = By.name("username");
		ElementUtil eUtil = new ElementUtil(driver);
		eUtil.doSendKeys(emailId, "pravin@gmail.com");
	}

}
