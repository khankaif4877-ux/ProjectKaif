package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class RRedBuss 
{
@Test
public void busPrice() throws InterruptedException
{
	WebDriver d=new ChromeDriver();
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	d.manage().window().maximize();
	d.get("https://www.redbus.in/");
	d.findElement(By.xpath("//div[text()='From']")).click();
	d.findElement(By.xpath("//div[text()='Mumbai']")).click();
	Actions act=new Actions(d);
	Thread.sleep(1000);
	act.sendKeys("Pune",Keys.ARROW_DOWN,Keys.ENTER).perform();
}
}
