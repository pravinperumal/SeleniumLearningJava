package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPageTest {

	public static void main(String[] args) throws InterruptedException {
		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.launchBrowser("Edge");
		
		ElementUtil eleUtil = new ElementUtil(driver); 		
		brUtil.enterUrl("https://demo.opencart.com/index.php?route=account/register&language=en-gb");
	
		String title = brUtil.getPageTitle();
		System.out.println(title);
		
		eleUtil.doSendKeys("id","input-firstname", "Pravin");
		eleUtil.doSendKeys("id","input-lastname", "Perumal");
		eleUtil.doSendKeys("id","input-email", "Pravin@gmail.com");
		eleUtil.doSendKeys("id","input-password", "password123");		
		
		Thread.sleep(5000);
		brUtil.closeBrowser();
	}
}
