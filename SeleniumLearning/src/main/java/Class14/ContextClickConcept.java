package Class14;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContextClickConcept {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        
        try {
            driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
            WebElement rightClickMe = driver.findElement(By.xpath("//span[text()='right click me']"));
            Actions act = new Actions(driver);
            act.contextClick(rightClickMe).perform();
            List<WebElement> listOfOptions = driver.findElements(By.xpath("//ul[@class='context-menu-list context-menu-root']/li[contains(@class,'context-menu-icon')]"));
            TakesScreenshot screenShot = (TakesScreenshot)driver;
            
            for(WebElement e: listOfOptions) {
                String text = e.getText();
                if(text.equalsIgnoreCase("Cut")) {
                    e.click();  
                    Thread.sleep(3000);
                }
            }
            File source = screenShot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File(".\\SeleniumScreenshots\\test.png"));        
        
            Thread.sleep(3000);    
        } catch (Exception e){
            
        } finally {
            driver.quit();
        }

    }

}
