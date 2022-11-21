package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchFirefox {

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "D:\\SeleniumDrivers\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.bing.com");
		List<WebElement> imageElements = driver.findElements(By.tagName("img"));
		for(WebElement e:imageElements) {
			System.out.println(e.getText());
		}
	}

}
