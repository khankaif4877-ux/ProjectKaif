package assignment;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Ninza_Hrm 
{
public static void main(String[] args) throws InterruptedException {
	final Map<String, Object> chromePrefs = new HashMap<>();
	chromePrefs.put("credentials_enable_service", false);
	chromePrefs.put("profile.password_manager_enabled", false);
	chromePrefs.put("profile.password_manager_leak_detection", false); // <======== This is the important one

	final ChromeOptions chromeOptions = new ChromeOptions();
	chromeOptions.setExperimentalOption("prefs", chromePrefs);
	WebDriver driver=new ChromeDriver(chromeOptions);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://49.249.28.218:8091/");
	driver.findElement(By.id("username")).sendKeys("rmgyantra");
	driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999",Keys.ENTER);
	
}
}
