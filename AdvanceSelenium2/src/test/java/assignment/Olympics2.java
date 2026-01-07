package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Olympics2 
{
public static void main(String[] args) 
{
	String player="Arlen LOPEZ";
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.olympics.com/en/olympic-games/tokyo-2020");
	driver.findElement(By.xpath("//button[text()='Yes, I am happy']")).click();
	driver.findElement(By.xpath("//li/a[text()='Results']")).click();
	Actions act=new Actions(driver);
	act.scrollByAmount(0, 1300).perform();
	driver.findElement(By.xpath("//p[text()='Boxing']")).click();
	driver.findElement(By.cssSelector("button[data-cy='event-select']")).click();
	driver.findElement(By.xpath("//p[text()=\"Men's Light Heavy (75-81kg)\"]")).click();
	driver.findElement(By.xpath("//span[text()='Go']")).click();
	WebElement playersTeam = driver.findElement(By.xpath("//div[@data-cy='single-athlete-result-row' and contains(.,'"+player+"')]//div[@data-cy='flag-with-label']/span"));
	System.out.println(playersTeam.getText());
}
}
