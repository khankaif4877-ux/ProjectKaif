package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class OlympicsParis 
{
public static void main(String[] args) 
{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.bbc.com/sport/olympics/paris-2024/medals");
	driver.findElement(By.xpath("//span[text()='Medal results']")).click();
	WebElement filterMedalRes = driver.findElement(By.id("discipline-selector"));
	Select sel=new Select(filterMedalRes);
	sel.selectByVisibleText("Badminton");
	List<WebElement> countryNames = driver.findElements(By.xpath("//div[contains(@class,'DesktopName')]/div[contains(@class,'SecondaryName')]"));
	for (WebElement countyName : countryNames) 
	{
		String nameText = countyName.getText();
		System.out.println(nameText);
	}
}
}
