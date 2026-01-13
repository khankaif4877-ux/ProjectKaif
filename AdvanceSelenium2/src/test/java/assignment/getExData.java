package assignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.mysql.cj.jdbc.Driver;

public class getExData 
{
public static void main(String[] args) throws EncryptedDocumentException, IOException, SQLException 
{
	WebDriver driver=null; 
	FileInputStream fis= new FileInputStream("C:\\Users\\afzau\\OneDrive\\Desktop\\Student\\Property.properties");
	Properties p=new Properties();
	p.load(fis);
	String Browser = p.getProperty("browser");
	String Url=p.getProperty("url");
	if(Browser.equals("chrome"))
	{
		driver=new ChromeDriver();
	}
	else if(Browser=="edge")
	{
	driver=new EdgeDriver();
			}
	else {
		driver=new FirefoxDriver();
	}
	driver.get(Url);
	
	FileInputStream fis1=new FileInputStream("C:\\Users\\afzau\\OneDrive\\Desktop\\Student\\Book2.xlsx");
	Workbook wb = WorkbookFactory.create(fis1);
	Sheet sh = wb.getSheet("Sheet1");
	System.out.println(sh.getRow(0).getCell(1));
	 String data = sh.getRow(1).getCell(1).getStringCellValue();
	driver.findElement(By.name("q")).sendKeys(data);
	Actions act=new Actions(driver);
	act.keyDown(Keys.ENTER).perform();
	act.keyUp(Keys.ENTER).perform();
	wb.close();
	
//	Get Data from JDBC
	Driver driverRef=new Driver();
	DriverManager.registerDriver(driverRef);
	Connection conn = DriverManager.getConnection("url","username", "pwd");
	Statement st = conn.createStatement();
	ResultSet result = st.executeQuery("select * from emp");
	System.out.println(result);
	
//	for display whole table
	while(result.next())
	{
		System.out.println(result.getString(0)+ "/t" +result.getString(1));
	}
conn.close();
	
}
}
