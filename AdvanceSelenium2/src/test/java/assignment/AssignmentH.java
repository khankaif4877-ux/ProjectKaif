package assignment;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentH {

	public static void main(String[] args) throws InterruptedException{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.findElement(By.xpath("//button[text()='Continue shopping']")).click();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Mobiles");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).submit();
		Thread.sleep(1000);
		WebElement checkBox = driver.findElement(By.xpath("//span[text()='Samsung']/preceding-sibling::div/label/input"));
		
		//driver.findElement(By.xpath("//span[text()='Samsung']")).click();
//		String mobName=driver.findElement(By.xpath("//div[@data-cy='title-recipe']/..//span[text()='Samsung Galaxy M05 (Mint Green, 4GB RAM, 64 GB Storage) | 50MP Dual Camera | Bigger 6.7\" HD+ Display | 5000mAh Battery | 25W Fast Charging | 2 Gen OS Upgrade & 4 Year Security Update | Without Charger']")).getText();
		String TitleAmz=driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).getText();
		System.out.println(TitleAmz);
//		List<WebElement> mobName=driver.findElements(By.xpath("//span[text()='Samsung Galaxy F06 5G, Bahama Blue (4GB, 128GB)']"));
		String mobname=driver.findElement(By.xpath("//span[text()='Samsung Galaxy S24 5G AI Smartphone (Amber Yellow, 8GB, 128GB Storage)']")).getText();
//		System.out.println(driver.findElement(By.xpath("//span[text()='Samsung Galaxy F06 5G, Bahama Blue (4GB, 128GB)']")).getText());
		System.out.println(mobname);
		String price=driver.findElement(By.xpath("//span[text()='Samsung Galaxy S24 5G AI Smartphone (Amber Yellow, 8GB, 128GB Storage)']/../../../..//span[@class='a-price-whole']")).getText();
		System.out.println(price);
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("shoes");
		driver.findElement(By.xpath("//input[@name='q']")).submit();
		driver.findElement(By.xpath("//div[text()='CAMPUS']/..//div[@class='XqNaEv']")).click();
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		
	}
	
}
