package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementsConcept {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://www.amazon.co.uk");
		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links are: "+linksList.size());
		
		for (int i = 0; i < linksList.size(); i++) {
			if(!(linksList.get(i).getText().isEmpty()) && !(linksList.get(i).getText().isBlank()) && (linksList.get(i).getText() != null))
				{
					if(i % 10 == 0)
						System.out.println(linksList.get(i).getText());
					else
						System.out.print(linksList.get(i).getText()+", ");
				}
		}
		driver.quit();
	}
}
