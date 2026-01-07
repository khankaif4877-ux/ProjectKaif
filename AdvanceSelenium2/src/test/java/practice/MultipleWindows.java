package practice;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MultipleWindows {
	@Test
	public void MultipleWindows() {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.com");
		driver.findElement(By.xpath("//button[text()='Continue shopping']")).click();
		String amazon = driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.flipkart.com/");
		String flipkart = driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.myntra.com/");
		String myntra = driver.getWindowHandle();
		
		
			driver.switchTo().window(amazon);
			
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		List<WebElement> countiPhone = driver.findElements(By.xpath("//div[@class='puisg-col-inner']//h2"));
		System.out.println(countiPhone.size());
		
		driver.switchTo().window(flipkart);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("iphone",Keys.ENTER);
		List<WebElement> count = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
		System.out.println(count.size());
		
		driver.switchTo().window(myntra);
		driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("Nike Shoe",Keys.ENTER);
		List<WebElement> shoes= driver.findElements(By.xpath("//h4[@class='product-product']"));
		for (WebElement ele : shoes) {
			System.out.println(ele.getText());
			
		}
	
	}

}
