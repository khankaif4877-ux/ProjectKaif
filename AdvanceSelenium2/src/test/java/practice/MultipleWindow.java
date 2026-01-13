package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindow {
	public static void main(String[] args) {
		
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.amazon.in/");
	
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get("https://www.flipkart.com/");
	
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get("https://www.myntra.com/");
	
	Set<String> winId = driver.getWindowHandles();
	for (String Id : winId) {
		driver.switchTo().window(Id);
		String title=driver.getTitle();
		System.out.println(title);
		
	}
	
	
	
	}
}
