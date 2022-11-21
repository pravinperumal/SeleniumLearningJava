package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

public class CloseVsQuit {
	
	static SessionId s;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bing.com");
		s = ((RemoteWebDriver) driver).getSessionId();
		System.out.println("Session id after starting the session: "+s.toString());
		System.out.println(driver.getTitle());
		System.out.println("Session id after printing the title: "+s.toString());
		driver.close();
		s = ((RemoteWebDriver) driver).getSessionId();
		if(s == null)
			System.out.println("Session id is null");
		else
			System.out.println("Session id after closing the session"+s);
	}
}
