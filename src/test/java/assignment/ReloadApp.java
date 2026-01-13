package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class ReloadApp 
{
public static void main(String[] args) 
{
	WebDriver driver=new ChromeDriver();
	
	WebElement element = driver.findElement(By.name("q"));
		FluentWait fwait=new FluentWait(driver);
		fwait.pollingEvery(Duration.ofMillis(1000));
		fwait.withTimeout(Duration.ofSeconds(20));
		fwait.until(ExpectedConditions.elementToBeClickable(element));
}
}