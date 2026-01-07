package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class IphoneCount {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.amazon.in/");
	
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.flipkart.com/");
		
	Set<String> WinId = driver.getWindowHandles();
	for (String Id : WinId) {
		driver.switchTo().window(Id);
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone",Keys.ENTER);
		
//		driver.findElement(By.name("q")).sendKeys("Iphone",Keys.ENTER);
		
		
	}
		
	

	}

}
