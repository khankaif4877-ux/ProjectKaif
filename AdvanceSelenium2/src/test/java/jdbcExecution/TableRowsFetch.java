package jdbcExecution;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TableRowsFetch 
{
public static void main(String[] args) 
{
	final Map<String, Object> chromePrefs = new HashMap<>();
	chromePrefs.put("credentials_enable_service", false);
	chromePrefs.put("profile.password_manager_enabled", false);
	chromePrefs.put("profile.password_manager_leak_detection", false); // <======== This is the important one

	final ChromeOptions chromeOptions = new ChromeOptions();
	chromeOptions.setExperimentalOption("prefs", chromePrefs);
	WebDriver d=new ChromeDriver(chromeOptions);
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	d.get("http://49.249.28.218:8091/");
	d.findElement(By.id("username")).sendKeys("rmgyantra");
	d.findElement(By.id("inputPassword")).sendKeys("rmgy@9999",Keys.ENTER);
	d.findElement(By.linkText("Projects")).click();
	d.findElement(By.cssSelector("input[placeholder='Search by Project Id']")).sendKeys("NH_PROJ_340",Keys.ENTER);
	List<WebElement> elements = d.findElements(By.xpath("//table//tr"));
	System.out.println(elements.size());
d.navigate().refresh();
	d.findElement(By.cssSelector("input[placeholder='Search by Project Id']")).sendKeys("NH_PROJ_3401",Keys.ENTER);
	List<WebElement> wrongElements = d.findElements(By.xpath("//table//tr"));
	System.out.println(wrongElements.size());
	
}
}
