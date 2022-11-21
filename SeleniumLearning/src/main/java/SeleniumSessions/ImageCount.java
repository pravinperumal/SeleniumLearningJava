package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageCount {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://www.amazon.co.uk");
		ElementUtil eUtil = new ElementUtil(driver);
		By images = By.tagName("img");
		List<WebElement> imagesList = eUtil.getElements("tagname","img");
						
		for(WebElement e: imagesList) {
			String alt = e.getAttribute("alt");
			String src = e.getAttribute("src");
			System.out.println(alt+" -----> "+src);
		}
		System.out.println("The number of images in the webpage are: "+imagesList.size());
		driver.quit();
	}
	
}
