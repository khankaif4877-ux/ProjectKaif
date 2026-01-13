package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ShadowR 
{
public static void main(String[] args) throws InterruptedException {
	WebDriver d=new ChromeDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	d.get("https://demoapps.qspiders.com/ui/shadow?sublist=0");
	d.findElement(By.id("details-button")).click();
	d.findElement(By.id("proceed-link")).click();
	d.findElement(By.xpath("//section[text()='Shadow Root Elements']")).click();
	d.findElement(By.xpath("//section[text()='Shadow Root']")).click();
	SearchContext userHost = d.findElement(By.xpath("(//div[@class='my-3'])[1]")).getShadowRoot();
	userHost.findElement(By.cssSelector("input[placeholder='Enter your username']")).sendKeys("afzaul");

	Thread.sleep(2000);
	d.findElement(By.linkText("Close Shadow Root")).click();
	Thread.sleep(2000);

	d.findElement(By.xpath("//h1[text()='Login']")).click();
	Actions act=new Actions(d);
	act.sendKeys(Keys.TAB).sendKeys("asdfghjk").perform();
}
}
