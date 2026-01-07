package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DisabledElement 
{
public static void main(String[] args) 
{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://demoapps.qspiders.com/ui?scenario=1");
	driver.findElement(By.xpath("//li[text()='Disabled']")).click();
	WebElement disabledElement = driver.findElement(By.xpath("//input[@Disabled and @id='name']"));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].removeAttribute('disabled')", disabledElement);
	disabledElement.sendKeys("haque");
}
}
