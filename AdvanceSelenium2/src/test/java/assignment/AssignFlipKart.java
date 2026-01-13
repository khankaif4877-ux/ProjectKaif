package assignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AssignFlipKart {

	public static void main(String[] args) throws IOException {
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
		FileInputStream fis1=new FileInputStream("./AdvanceSelenium/data/Demo.xlsx");
Workbook wb = WorkbookFactory.create(fis1);
Cell cell = wb.getSheet("Sheet1").getRow(1).getCell(1);
String data = cell.getStringCellValue();
System.out.println(data);
//
//		driver.findElement(By.name("q")).sendKeys(data);
//		
 wb.close();
		}

}

