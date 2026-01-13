package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClearFlipkart {
public static void main(String[] args) {
	WebDriver d=new ChromeDriver();
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	d.manage().window().maximize();
	d.get("https://www.flipkart.com");
	WebElement stf = d.findElement(By.name("q"));
	stf.sendKeys("mobiles");
	stf.clear();
	stf.sendKeys("shoes",Keys.ENTER);
}
}
