package assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IncognitoMode 
{
	 public static void main(String[] args) throws InterruptedException {
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--incognito");

	        WebDriver d=new ChromeDriver();
	        d.get("https://www.flipkart.com");
	        Thread.sleep(2000);
	        
	        WebDriver driver = new ChromeDriver(options);
	        driver.get("https://www.flipkart.com");
	    }
}
