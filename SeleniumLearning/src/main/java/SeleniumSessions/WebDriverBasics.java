package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBasics {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\grang\\Downloads\\chromedriver_win32\\chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		
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
