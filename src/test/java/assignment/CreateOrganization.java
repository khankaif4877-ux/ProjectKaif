package assignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CreateOrganization 
{
public static void main(String[] args) throws EncryptedDocumentException, IOException 
{
	FileInputStream fis= new FileInputStream("C:\\SeleniumFiles\\LocalHst.xlsx");
	Workbook workbook = WorkbookFactory.create(fis);
	Sheet sheet = workbook.getSheet("localHost1");
	String browser=sheet.getRow(0).getCell(1).getStringCellValue();
	String url= sheet.getRow(1).getCell(1).getStringCellValue();
	String username= sheet.getRow(2).getCell(1).getStringCellValue();
	String password= sheet.getRow(3).getCell(1).getStringCellValue();
	
	WebDriver driver=null;
	if(browser.equals("chrome"))
	{
		driver= new ChromeDriver();
	}
	else if(browser.equals("edge"))
	{
		driver= new EdgeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(url);
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).submit();
	driver.findElement(By.xpath("//td[@class='tabUnSelected']/a[text()='Organizations']")).click();
	driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys("newUser");
	driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
	driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']")).click();
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
}
}