package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {

	static WebDriver driver;

	/*
	 * This method is used to launch the browser on the basis of the name given
	 * 
	 * @param browser
	 * 
	 * @return this will return the corresponding driver
	 */

	public WebDriver launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} 
		else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}  
		else if(browser.equalsIgnoreCase("Edge")){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} 
		else {
			System.out.println("Please pass the correct browser. The browser input is: "+browser);
		}
		return driver;
	}

	/*
	 * This method is used to enter the url
	 * 
	 * @param url
	 */
	public void enterUrl(String url) {
		if (url == null) {
			System.out.println("URL is null");
			return;
		}
		if (url.indexOf("http") == -1) {
			System.out.println("http is missing in url");
			return;
		}
		driver.get(url);
	}

	/*
	 * This method will return current page URL
	 */
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}

}
