package practiceDataDrivenTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleDataDrivenTest 
{
public static void main(String[] args) throws IOException 
{
	FileInputStream fis= new FileInputStream("C:\\SeleniumFiles\\localHostData.properties");
	Properties pobj= new Properties();
	pobj.load(fis);
	String urlText=pobj.getProperty("url");
	System.out.println(urlText);
	String browserName=pobj.getProperty("browser");
	String userName= pobj.getProperty("username");
	String password= pobj.getProperty("password");
	
	System.out.println(browserName);
	WebDriver driver=null;
	if(browserName.equals("chrome"))
	{
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	}
	driver.get(urlText);
	driver.findElement(By.name("user_name")).sendKeys(userName);
	driver.findElement(By.name("user_password")).sendKeys(password);
}
}
