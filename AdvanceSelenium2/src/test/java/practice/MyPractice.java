package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MyPractice {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		driver.get("https://www.amazon.in/");
		
		
		
//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.get("https://www.myntra.com/");
//		
//		Set<String> windowHandles = driver.getWindowHandles();
//		System.out.println(windowHandles);
		
			
		
//		String title= driver.getTitle();
//		System.out.println(title);
//		
//		String Url=driver.getCurrentUrl();
//		System.out.println(Url);
////		
//		Dimension size = driver.manage().window().getSize();
//		System.out.println(size);
//		
//		Point position = driver.manage().window().getPosition();
//		System.out.println(position);
		
//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.navigate().to("https://www.flipkart.com/");
		
//		String WinId = driver.getWindowHandle();
//		System.out.println(WinId);
		
		
//		Web Inputs:
//		driver.get("https://practice.expandtesting.com/inputs");
//		driver.findElement(By.id("input-number")).sendKeys("123456");
//		driver.findElement(By.id("input-text")).sendKeys("ABCDEFG");
//		driver.findElement(By.id("input-password")).sendKeys("ABC@12345");
//		driver.findElement(By.id("input-date")).sendKeys("11-07-2025");
		
		
//		Dropdown:
		driver.get("https://practice.expandtesting.com/dropdown");
		WebElement dropdown = driver.findElement(By.id("dropdown"));
		Select sel=new Select(dropdown);
//		sel.selectByVisibleText("Option 1");
		sel.selectByValue("2");
		List<WebElement> options = sel.getOptions();
		for (WebElement opt : options) {
		System.out.println(opt.getText());
		}
		
		WebElement elementDD = driver.findElement(By.id("elementsPerPageSelect"));
		Select sel1= new Select(elementDD);
		sel1.selectByValue("50");
		WebElement SelectedOption = sel1.getFirstSelectedOption();
		System.out.println(SelectedOption.getText());
		List<WebElement> options2 = sel1.getOptions();
		for (WebElement opt2 : options2) {
			System.out.println(opt2.getText());
		}
		
		WebElement country = driver.findElement(By.id("country"));
		Select sel2 = new Select(country);
		sel2.selectByVisibleText("India");
		sel2.deselectAll();
		List<WebElement> options3 = sel2.getOptions();
		for (WebElement opt3 : options3) {
			System.out.println(opt3.getText());
			
		}
		
		
	}

}
