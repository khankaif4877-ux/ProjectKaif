package practiceDataDrivenTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromExcel 
{
public static void main(String[] args) throws EncryptedDocumentException, IOException 
{
	FileInputStream fis=new FileInputStream("C:\\SeleniumFiles\\LocalHst.xlsx");
	Workbook workbook = WorkbookFactory.create(fis);
	Sheet sheet=workbook.getSheet("localHost1");
}
}
