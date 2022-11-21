package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RediffMailTest {

    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        driver.findElement(By.name("proceed")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();
    }
    
}
