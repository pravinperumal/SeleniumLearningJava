package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationMethods {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bing.com");
		System.out.println(driver.getTitle());
		driver.navigate().to("https://www.amazon.co.uk");
		System.out.println(driver.getTitle());
		driver.navigate().back();
		System.out.println(driver.getTitle());
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		driver.navigate().back();
		System.out.println(driver.getTitle());
	}
}
