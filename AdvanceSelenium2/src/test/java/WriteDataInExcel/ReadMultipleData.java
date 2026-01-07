package WriteDataInExcel;

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
	FileInputStream fis= new FileInputStream("C:\\SeleniumFiles\\MobilesList.xlsx");
	Workbook workbook=WorkbookFactory.create(fis);
	Sheet sheet=workbook.getSheet("Sheet2");
	int lastRow=sheet.getLastRowNum();
	for(int i=0;i<=lastRow;i++)
	{
		String data1=sheet.getRow(i).getCell(1).toString();
		System.out.println(data1);
		String data2=sheet.getRow(i).getCell(2).toString();
		System.out.println(data2);
		String data3=sheet.getRow(i).getCell(3).toString();
		System.out.println(data3);
	}
}
}
