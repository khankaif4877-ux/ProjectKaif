package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PracticeStaticNonStatic 
{

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.geeksforgeeks.org/difference-between-static-and-non-static-method-in-java/");
		Actions act=new Actions(driver);
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='all-footer-information']//li"));
		for(WebElement ele:elements)
		{
			act.moveToElement(ele).perform();
			System.out.println(ele.getText());
		}
	}
}
