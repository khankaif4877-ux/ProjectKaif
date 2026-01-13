package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentH2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/frames/nested?sublist=1");
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		String email=driver.findElement(By.xpath("//p[text()='Admin@gmail.com']")).getText();
		String password=driver.findElement(By.xpath("//p[text()='Default Confirm Password']/preceding-sibling::p[text()='Admin@1234']")).getText();
		String confirmpwd=driver.findElement(By.xpath("//p[text()='Default Confirm Password']/following-sibling::p[text()='Admin@1234']")).getText();
		Thread.sleep(2000);
		System.out.println(email);
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class=\"form_container\"]/iframe")));
		WebElement element = driver.findElement(By.cssSelector("input[id='email']"));
		element.sendKeys(email);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='confirm-password']")).sendKeys(confirmpwd);
		driver.findElement(By.xpath("//button[@id='submitButton']")).click();
		driver.switchTo().defaultContent();
		System.out.println("done");
	}
	

}
