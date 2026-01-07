package OrgAssignStudent;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrgWithPropertiesFile {

	public static void main(String[] args) throws IOException {
		WebDriver driver=null;
		FileInputStream fis=new FileInputStream("C:\\Users\\afzau\\OneDrive\\Desktop\\Student\\Data.properties");
		Properties p=new Properties();
		p.load(fis);
		String Browser = p.getProperty("browser");
		String Url=p.getProperty("url");
		String un = p.getProperty("username");
		String pwd = p.getProperty("password");
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		Random rd=new Random();
		int num = rd.nextInt(100);
		
		FileInputStream fis2= new FileInputStream("C:\\Users\\afzau\\OneDrive\\Desktop\\Student\\OrgData.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		String org = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
				
		driver.findElement(By.name("accountname")).sendKeys(org + num);
		driver.findElement(By.name("button")).click();
				
		WebElement element = driver.findElement(By.name("industry"));
		Select s=new Select(element);
		s.selectByValue("Utilities");
		
		WebElement element2 = driver.findElement(By.name("accounttype"));
		Select s1=new Select(element2);
		s1.selectByValue("Customer");
		
	
    //	Back data to exel	
		 Row row = wb.getSheet("Sheet1").getRow(1);
		 Cell cell = row.createCell(3);
		 cell.setCellType(CellType.STRING);
		 cell.setCellValue("Pass");
		 FileOutputStream fos=new FileOutputStream("C:\\Users\\afzau\\OneDrive\\Desktop\\Student\\OrgData.xlsx");
		 wb.write(fos);
		
		
		
		wb.close();
		driver.close();
		

	}

}
