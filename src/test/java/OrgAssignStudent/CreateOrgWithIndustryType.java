package OrgAssignStudent;

import java.time.Duration;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrgWithIndustryType {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		Random rd=new Random();
		int num = rd.nextInt(100);
		driver.findElement(By.name("accountname")).sendKeys("Qspiders_" + num);
		driver.findElement(By.name("button")).click();
		
		WebElement element = driver.findElement(By.name("industry"));
		Select s=new Select(element);
		s.selectByValue("Utilities");
		
		WebElement element2 = driver.findElement(By.name("accounttype"));
		Select s1=new Select(element2);
		s1.selectByValue("Customer");
		
		driver.close();
		

	}

}
