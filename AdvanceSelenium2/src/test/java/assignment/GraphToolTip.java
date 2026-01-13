package assignment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GraphToolTip 
{
public static void main(String[] args) throws InterruptedException 
{
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.worldometers.info/world-population/india-population/");    

    WebElement graph = driver.findElement(By.xpath("//google-chart[contains(.,'India Population')]"));
    Actions act = new Actions(driver);

    act.moveToElement(graph).perform();
    // Locate graph SVG path points
    String tooltipPath="//google-chart[contains(.,'India Population')]//*[name()='svg']//*[name()='g' and @class='google-visualization-tooltip']";
    WebElement graphPoints = driver.findElement(By.xpath(tooltipPath));

    System.out.println(graphPoints.getText());

}
}
