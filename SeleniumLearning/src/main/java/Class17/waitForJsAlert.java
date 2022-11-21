package Class17;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class waitForJsAlert {
    
    static WebDriver driver;
    
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        driver.findElement(By.name("proceed")).click();
        
    }
    
    public static Alert waitForAlert(int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.alertIsPresent());
    }
    
    public static String getAlertText(int timeout) {
        return waitForAlert(timeout).getText();
    }
    
    public static void doAlertAccept(int timeout) {
        waitForAlert(timeout).accept();
    }
    
    public static void doAlertDismiss(int timeout) {
        waitForAlert(timeout).dismiss();
    }
    
    public static void enterAlertText(String text, int timeout) {
        waitForAlert(timeout).sendKeys(text);;
    }
}
