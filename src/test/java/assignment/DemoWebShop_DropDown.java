package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DemoWebShop_DropDown 
{
	
public static void main(String[] args) throws InterruptedException 
{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://demowebshop.tricentis.com/books");
	
	WebElement position = driver.findElement(By.id("products-orderby"));
	Select sel=new Select(position);
	sel.selectByVisibleText("Name: A to Z");
	
	
	WebElement size = driver.findElement(By.id("products-pagesize"));
	Select selSize=new Select(size);
	selSize.selectByValue("https://demowebshop.tricentis.com/books?orderby=5&pagesize=12");
	
	WebElement grid = driver.findElement(By.id("products-viewmode"));
	Select selGrid=new Select(grid);
	selGrid.selectByValue("https://demowebshop.tricentis.com/books?orderby=5&pagesize=12&viewmode=list");
}
}
