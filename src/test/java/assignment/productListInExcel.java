package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class productListInExcel 
{
@Test
public void addProductInExcel()
{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.flipkart.com");
	driver.findElement(By.name("q")).sendKeys("iphone",Keys.ENTER);
	List<WebElement> prodList = driver.findElements(By.xpath("//div[@class='yKfJKb row']//div[@class='KzDlHZ' or @class='Nx9bqj _4b5DiR']"));
	
	System.out.println(prodList.size());
	int size = 0;
	for (WebElement prod : prodList) 
	{
		size++;
		System.out.println(size+" => "+prod.getText());
	}
}
}
