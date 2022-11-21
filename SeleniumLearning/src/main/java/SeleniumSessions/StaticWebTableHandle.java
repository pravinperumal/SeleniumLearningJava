package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticWebTableHandle {

    public static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        EdgeOptions eOptions = new EdgeOptions();
        eOptions.addArguments("--inprivate");
        driver = new EdgeDriver(eOptions);
        driver.manage().window().maximize();

        By rowXpath = By.xpath("//table[@id='customers']//tr");
        By columnXpath = By.xpath(("//table[@id='customers']//tr/th"));
        String beforeXpath = "//table[@id='customers']//tr[";
        String afterXpath = "]/td[";
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        
        printTable(rowXpath,columnXpath, beforeXpath, afterXpath );
        driver.quit();
    }
    
    public static void printTable(By rowXpath, By columnXpath, String beforeXpath, String afterXpath){
        int rowCount = driver.findElements(rowXpath).size();
        int colCount = driver.findElements(columnXpath).size();
        System.out.println();
        for (int rowNo = 2; rowNo <= rowCount; rowNo++) {            
            for (int columnNo = 1; columnNo <= colCount; columnNo++) {
                String xpath = beforeXpath+rowNo+afterXpath+columnNo+"]";
                String text = driver.findElement(By.xpath(xpath)).getText();
                System.out.print(text+", ");
            }
            System.out.println();
        }
    }
}
