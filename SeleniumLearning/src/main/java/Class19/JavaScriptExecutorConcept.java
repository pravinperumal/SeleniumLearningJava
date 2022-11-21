package Class19;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorConcept {
    
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
           
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://www.google.com/");
        
        JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
        System.out.println(jsUtil.getTitleByJS());;
        
        String innerText = jsUtil.getPageInnerText();
        System.out.println(innerText);
        
        Thread.sleep(1000);
        driver.quit();

    }

}
