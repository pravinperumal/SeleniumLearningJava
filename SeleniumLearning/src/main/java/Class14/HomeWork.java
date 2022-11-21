package Class14;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeWork {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
            WebElement rightClickMe = driver.findElement(By.xpath("//span[text()='right click me']"));
            Actions act = new Actions(driver);
            act.contextClick(rightClickMe).build().perform();
            List<WebElement> listOfOptions = driver
                    .findElements(By.xpath("//ul[@class='context-menu-list context-menu-root']/li"));
            for (WebElement e : listOfOptions) {
                System.out.println(e.getText());
            }

//            for (WebElement e : listOfOptions) {
//                e.click();
//                Thread.sleep(5000);
//                Alert alert = driver.switchTo().alert();
//                alert.accept();
//                System.out.println(e.getText() + " - alert accepted");
//                Thread.sleep(3000);
//           }

        } catch (Exception e) {
            System.out.println("##############################Exception Occured##############################");
            System.out.println(e.getClass().toString());
            e.printStackTrace();
            System.out.println("#############################################################################");
        } finally {
            driver.quit();
        }

    }

}
