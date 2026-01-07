package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MMTBooking 
{
@Test
public void mmtBook() throws InterruptedException
{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.makemytrip.com/?msockid");
	driver.findElement(By.className("commonModal__close")).click();
	driver.findElement(By.cssSelector("label[for='fromCity']")).click();
	driver.findElement(By.cssSelector("input[placeholder='From']")).sendKeys("mumbai",Keys.ARROW_DOWN,Keys.ENTER);
	driver.findElement(By.cssSelector("label[for='toCity']")).click();
	WebElement toCity = driver.findElement(By.cssSelector("input[placeholder='To']"));
	toCity.sendKeys("bengaluru");
	Thread.sleep(500);
	toCity.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
	driver.findElement(By.cssSelector("div[aria-label='Wed Apr 23 2025']")).sendKeys(Keys.ENTER);
	driver.findElement(By.linkText("Search")).click();
	

}
@Test
public void airIndia()
{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.airindia.com/?utm_source");
	
}
}
