package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cricbuzz2 
{
public static void main(String[] args) 
{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.bcci.tv/international/men/rankings/test");
	driver.findElement(By.cssSelector("button[data-format='t20']")).click();
	WebElement indiaRating = driver.findElement(By.xpath("//div[@class='trw-right' and contains(.,'India')]//td[contains(.,'Rating')]/p"));
	System.out.println(indiaRating.getText());
}
}
