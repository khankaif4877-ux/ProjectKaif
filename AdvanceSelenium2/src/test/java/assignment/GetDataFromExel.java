package assignment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetDataFromExel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		String path="C:\\Users\\afzau\\OneDrive\\Desktop\\Student\\OrgData.xlsx";
		Workbook wb=null;
		try {
		FileInputStream fis=new FileInputStream(path);
		wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		Row r = sh.getRow(1);
		Cell c = r.getCell(1);
		String data = c.toString();
		System.out.println(data);
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys("iphone",Keys.ENTER);
		String text = driver.findElement(By.xpath("//div[@class='KzDlHZ']")).getText();
		sh.getRow(3).createCell(1,CellType.STRING).setCellValue(text);
		FileOutputStream fos=new FileOutputStream(path);
		wb.write(fos);
		System.out.println(sh.getRow(3).getCell(1).toString());
		}
		finally {
		wb.close();
		}
	}
}
