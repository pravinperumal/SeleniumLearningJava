package Class13;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricketScoreTable {
    
    static WebDriver driver;

    public static void main(String[] args) throws Exception {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        String sourceURL = 
                "https://www.espncricinfo.com/series/the-marsh-cup-2022-23-1322366/tasmania-vs-victoria-9th-match-1322382/full-scorecard";
        driver.get(sourceURL);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='onetrust-close-btn-container']/button")).click();
        System.out.println(getWicketTakerName("Will Sutherland"));
        List<String> playerScoreValue = getPlayerScoreCard("Will Sutherland");
        System.out.println(playerScoreValue);
    }
    
    public static String getWicketTakerName(String playerName) {
        String xpath = "//span[text()='"+playerName+"'][1]//ancestor::tr//td[2]";
        return driver.findElement(By.xpath(xpath)).getText();
    }
    
    public static List<String> getPlayerScoreCard(String playerName) {
        String xpath = "//span[text()='"+playerName+"'][1]//ancestor::tr/td/following-sibling::td";
        List<WebElement> PlayerScores = driver.findElements(By.xpath(xpath));
        List<String> scoreValList = new ArrayList<String>();
        for (int i = 1; i < 7; i++) {
            String text = PlayerScores.get(i).getText();
            scoreValList.add(text);
        }
        return scoreValList;
            
    }

}
