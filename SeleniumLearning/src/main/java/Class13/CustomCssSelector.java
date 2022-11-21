package Class13;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomCssSelector {

    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver=  new EdgeDriver();
        driver.get("https://app.hubspot.com/login");
        
        List<WebElement> formFields = driver.findElements(By.cssSelector("input#username, input#password, button#loginBtn, label#UIFormControl-label-4"));
        System.out.println(formFields.size());
        for (WebElement webElement : formFields) {
            System.out.println(webElement.getText());
        }
        driver.quit();
    }

}
