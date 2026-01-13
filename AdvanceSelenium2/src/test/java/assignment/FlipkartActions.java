package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FlipkartActions 
{
public static void main(String[] args) throws InterruptedException 
{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://demowebshop.tricentis.com/books");
	WebElement dd = driver.findElement(By.id("products-orderby"));
	Select s=new Select(dd);
	s.selectByIndex(2);
	Thread.sleep(2000);
	WebElement dd2 = driver.findElement(By.id("products-orderby"));
	Select s2=new Select(dd2);
	s2.deselectByIndex(2);
	
}
}
