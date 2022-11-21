package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SuggestionListHandle {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationpractice.com");
        By searchBox = By.id("search_query_top");
        driver.findElement(searchBox).sendKeys("d");
        Thread.sleep(5000);
        driver.findElement(searchBox).sendKeys("ress ");
        Thread.sleep(10000);
        // List<WebElement> clothingOptions = driver.findElements(By.xpath("//*[@class='ac_results']/ul/li"));
        // for (WebElement webElement : clothingOptions) {
        //     System.out.println(webElement.getText());
        // }

        selectOptionfromSuggList("Summer Dresses > Printed Chiffon Dress");
        // for (WebElement displayedOption : clothingOptions) {
        //     if(displayedOption.getText().equals("Casual Dresses > Printed Dress")){
        //         displayedOption.click();
        //         break;
        //     }
        // }
        Thread.sleep(10000);
        driver.quit();
    }

    public static void selectOptionfromSuggList(String value){
        driver.findElement(By.xpath("//*[@class='ac_results']/ul/li[contains(text(),'"+value+"')]")).click();;
    }

}
