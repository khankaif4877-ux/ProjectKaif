package OrgAssignStudent;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReturnDataToExel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis2= new FileInputStream("C:\\Users\\afzau\\OneDrive\\Desktop\\Student\\OrgData.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		
		 Row row = wb.getSheet("Sheet1").getRow(1);
		 Cell cell = row.createCell(3);
		 cell.setCellType(CellType.STRING);
		 cell.setCellValue("Pass");
		 FileOutputStream fos=new FileOutputStream("C:\\Users\\afzau\\OneDrive\\Desktop\\Student\\OrgData.xlsx");
		 wb.write(fos);
		 wb.close();


	}

}
