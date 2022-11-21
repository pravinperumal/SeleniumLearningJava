package Class20;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ColorTest {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }
}
