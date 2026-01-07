package assignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrgByReadingTestData 
{
public static void main(String[] args) throws IOException 
{
	Random random=new Random();
	int randomInt=random.nextInt(1000);
	FileInputStream propertyFile= new FileInputStream("C:\\SeleniumFiles\\localHostData.properties");
	Properties pobj= new Properties();
	pobj.load(propertyFile);
	String browser= pobj.getProperty("browser");
	String url= pobj.getProperty("url");
	String username=pobj.getProperty("username");
	String password=pobj.getProperty("password");

	WebDriver driver=null;
	if(browser.equals("chrome"))
	{
		driver= new ChromeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(url);
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	//driver.findElement(By.id("submitButton")).submit();
	
	FileInputStream excelFile= new FileInputStream("C:\\SeleniumFiles\\MobilesList.xlsx");
	Workbook wb= WorkbookFactory.create(excelFile);
	Sheet sheet = wb.getSheet("Sheet2");
	String orgName=sheet.getRow(2).getCell(2).toString();

	driver.findElement(By.xpath("//td[@class='tabUnSelected']/a[text()='Organizations']")).click();
	driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys(orgName+randomInt);
	driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
//	driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']")).click();
//	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
//	
	wb.close();
}
}
