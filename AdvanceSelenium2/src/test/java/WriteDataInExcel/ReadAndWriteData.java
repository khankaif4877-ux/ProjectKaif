package WriteDataInExcel;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadAndWriteData 
{
public static void main(String[] args) throws EncryptedDocumentException, IOException 
{
	WebDriver d=new ChromeDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	d.get("https://www.w3schools.com/html/html_tables.asp");
	
	FileInputStream fis=new FileInputStream("./data/readAndWriteData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet1");
	
	List<WebElement> allRows = d.findElements(By.xpath("//table[@id='customers']//tr"));
	for(int i=1;i<=allRows.size();i++)
	{
		Row excelRow = sh.createRow(i-1);
		List<WebElement> tableCells = d.findElements(By.xpath("//table[@id='customers']//tr["+i+"]/td"));
		for(int j=1;j<=tableCells.size();j++)
		{
			String text = d.findElement(By.xpath("//table[@id='customers']//tr["+i+"]/td["+j+"]")).getText();
			excelRow.createCell(j-1, CellType.STRING).setCellValue(text);
		}
	}
	FileOutputStream fos=new FileOutputStream("./data/readAndWriteData.xlsx");
	wb.write(fos);
	wb.close();
	System.out.println("done");
}
}
