package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cricbuzz1 
{
public static void main(String[] args) 
{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.bcci.tv/international/men/rankings/test");
	WebElement indiarating = driver.findElement(By.xpath("//tr[contains(.,'India')]//span[text()='Ratings']/parent::td/p"));
	System.out.println(indiarating.getText());
}
}
