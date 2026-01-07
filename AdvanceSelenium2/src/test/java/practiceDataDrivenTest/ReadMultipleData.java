package practiceDataDrivenTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleData 
{
public static void main(String[] args) throws EncryptedDocumentException, IOException 
{
	FileInputStream fis = new FileInputStream("C:\\SeleniumFiles\\MobilesList.xlsx");
	Workbook workbook = WorkbookFactory.create(fis);
	Sheet sheet = workbook.getSheet("phones");
	int totalRow=sheet.getLastRowNum();
	for(int i=0;i<=totalRow;i++)
	{
	String column1Data = sheet.getRow(i).getCell(0).toString();
	String column2Data = sheet.getRow(i).getCell(1).toString();
	System.out.println(column1Data+"  "+column2Data);
	}

	System.out.println("total count = "+(sheet.getLastRowNum()+1));
}
}
