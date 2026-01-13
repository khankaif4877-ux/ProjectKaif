package practiceDataDrivenTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromXmlTest 
{
@Test
public void sampleTest(XmlTest test)
{
	System.out.println("executed class 2");
	String browser=test.getParameter("browser");
	String url=test.getParameter("url");
	String username=test.getParameter("username");
	String password=test.getParameter("password");
	WebDriver driver=null;
	if(browser.equals("chrome"))
	{
	 driver= new ChromeDriver();
	}
	driver.manage().window().maximize();
	driver.get(url);
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	//driver.findElement(By.id("submitButton")).submit();
}
}
