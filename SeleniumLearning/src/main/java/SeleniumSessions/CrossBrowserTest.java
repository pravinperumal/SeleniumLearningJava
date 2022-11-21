package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowserTest {
	
	static WebDriver driver;

	public static void main(String[] args) {
		String browser = "chrome";
		
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\SeleniumDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\SeleniumDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.edge.driver", "D:\\SeleniumDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		try {			
			driver.get("http://www.bing.com");
			String title = driver.getTitle();
			System.out.println("The page title is: "+title);
			if(title.equals("Bing")) {
				System.out.println("Pass");
			}
			else {
				System.out.println("Fail");
			}
			System.out.println(driver.getCurrentUrl());
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		driver.quit();
	}
}
