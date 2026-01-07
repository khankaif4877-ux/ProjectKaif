package WriteDataInExcel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataInExcelSheet 
{
public static void main(String[] args) throws EncryptedDocumentException, IOException 
{
	FileInputStream fis= new FileInputStream("C:\\SeleniumFiles\\MobilesList.xlsx");
	Workbook workbook=WorkbookFactory.create(fis);
	Row row = workbook.getSheet("Sheet2").getRow(3);
	Cell cell=row.createCell(4);
	cell.setCellType(CellType.STRING);
	cell.setCellValue("passed");
	FileOutputStream fos= new FileOutputStream("C:\\SeleniumFiles\\MobilesList.xlsx");
	workbook.write(fos);
	workbook.close();
	System.out.println("executed");
}
}
