package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentH1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/frames?sublist=0");
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
//		driver.switchTo().frame(2);
//		driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
		Thread.sleep(2000);
		WebElement txt =driver.findElement(By.xpath("//label[text()='Username:']"));
		System.out.println(txt);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("test@xyz");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("test123");
		driver.findElement(By.xpath("//button[@id='submitButton']")).click();
	}

}
