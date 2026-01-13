package assignment;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Amazon_ProductColorTest 
{
	@Test
	public void product_ColorTest() throws InterruptedException
{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https:www.amazon.in");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);
	driver.findElement(By.xpath("//span[text()='Apple iPhone 15 (128 GB) - Pink']")).click();
	Set<String> widIds = driver.getWindowHandles();
	for (String widId : widIds) 
	{
		driver.switchTo().window(widId);
		String title = driver.getTitle();
		if(title.contains("Apple iPhone 15 (128 GB) - Pink"))
		{
			break;
		}
	}
	Actions act=new Actions(driver);
	List<WebElement> allColors = driver.findElements(By.xpath("//span[contains(@class,'button-with-slots')]//img"));
	for (WebElement color : allColors)
	{
		color.getAttribute("title");
		act.moveToElement(color).perform();
		Thread.sleep(1000);
		String imgColor = color.getAttribute("alt");
		WebElement printedColor = driver.findElement(By.id("inline-twister-expanded-dimension-text-color_name"));
		System.out.println("printed color =>  "+printedColor.getText()+" : and image color => "+imgColor);
		Assert.assertEquals(imgColor, printedColor.getText());
	}
}
}
