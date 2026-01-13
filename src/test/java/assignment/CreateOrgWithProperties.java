package assignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CreateOrgWithProperties 
{
public static void main(String[] args) throws IOException 
{
	FileInputStream fis= new FileInputStream("C:\\SeleniumFiles\\LocalhostEdge.properties");
	Properties pobj = new Properties();
	pobj.load(fis);
	String browser = pobj.getProperty("browser");
	String url = pobj.getProperty("url");
	String username= pobj.getProperty("username");
	String password= pobj.getProperty("password");
	WebDriver driver=null;
	if(browser.equals("edge"))
	{
		driver= new EdgeDriver();
	}
	driver.manage().window().maximize();
	driver.get(url);
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	
	driver.findElement(By.id("submitButton")).submit();
	driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']")).click();
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
}
}
