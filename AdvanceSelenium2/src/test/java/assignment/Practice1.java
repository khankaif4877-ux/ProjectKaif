package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Practice1 {

@Test
public void searchProject()
{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://49.249.28.218:8091/dashboard/projects");
	
	String name = driver.findElement(By.id("username")).getDomAttribute("name");
	System.out.println(name);
	driver.findElement(By.cssSelector("input[placeholder='Search by Project Id']"));
}
}
