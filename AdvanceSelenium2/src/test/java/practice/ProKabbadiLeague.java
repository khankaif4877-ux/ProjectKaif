package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ProKabbadiLeague {
	@Test
	public void ProKabbadiLeague() throws InterruptedException{
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.prokabaddi.com/schedule-fixtures-results");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		
		List<WebElement> list = driver.findElements(By.xpath("//p[text()='Final']/ancestor::div[@class='fixtures-element']//p[@class='score']"));
		
		String Team1 = list.get(0).getText();
		String Team2 = list.get(1).getText();
		
		int Team1Point = Integer.parseInt(Team1);
		int Team2Point = Integer.parseInt(Team2);
		
		int Difference = Team1Point-Team2Point;
		
		System.out.println(Difference);
		
		
		
		
		
		
		
	}

}
