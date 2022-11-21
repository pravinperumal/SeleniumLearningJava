package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessBrowser {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		EdgeOptions co = new EdgeOptions();
		co.addArguments("--headless");
		WebDriver driver = new EdgeDriver(co);
		
		driver.get("https://www.google.com");
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		
		driver.quit();
	}
}
