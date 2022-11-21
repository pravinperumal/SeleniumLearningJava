package Class16;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitConcept {

    static WebDriver driver;
    
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        driver.get("");

    }

}
