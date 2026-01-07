package assignment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FlipkartProductsVerify 
{
@Test
public void verifyProducts() throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream("C:\\Users\\afzau\\OneDrive\\Desktop\\assignment.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet("flipkartIphones");
	System.out.println(sheet.getRow(0).getCell(0).getStringCellValue());
	sheet.getRow(0).createCell(0, CellType.STRING).setCellValue("Sl_No");
	sheet.getRow(0).createCell(2, CellType.STRING).setCellValue("Price");

	int rowNum=1;
	int slNo=1;
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.flipkart.com");
	WebElement srchTF = driver.findElement(By.name("q"));
	srchTF.sendKeys("iphone");
	srchTF.sendKeys(Keys.ENTER);
	List<WebElement> iphones = driver.findElements(By.className("KzDlHZ"));
	for(WebElement iphone:iphones)
	{
		String iphoneName = iphone.getText();
		String price = driver.findElement(By.xpath("//a[@class='CGtC98' and contains(.,'"+iphoneName+"')]//div[@class='Nx9bqj _4b5DiR']")).getText();
		System.out.println(iphoneName);
		Row row = sheet.getRow(rowNum);
		row.createCell(0,CellType.NUMERIC).setCellValue(slNo);
		row.createCell(1,CellType.STRING).setCellValue(iphoneName);
		row.createCell(2,CellType.STRING).setCellValue(price);
		rowNum++;
		slNo++;
	}
	FileOutputStream fos=new FileOutputStream("C:\\Users\\afzau\\OneDrive\\Desktop\\assignment.xlsx");
	wb.write(fos);
	wb.close();
	System.out.println("====done===========");
}
}