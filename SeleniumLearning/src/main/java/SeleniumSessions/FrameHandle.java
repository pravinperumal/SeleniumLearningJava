package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("http://londonfreelance.org/courses/frames/index.html");
		driver.switchTo().frame("main");
		String header = driver.findElement(By.xpath("/html/body/h2")).getText();
		System.out.println(header);
		Thread.sleep(5000);
		driver.close();
	}
}
