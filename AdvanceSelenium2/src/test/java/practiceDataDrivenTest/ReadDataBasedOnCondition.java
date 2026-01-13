package practiceDataDrivenTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnCondition 
{
public static void main(String[] args) throws EncryptedDocumentException, IOException 
{
	String data="";
	String data1="";
	String data2="";
	String data3="";
	String data4="";
	boolean flag=false;
	String expectedTestCase="tc_03";
	FileInputStream fis = new FileInputStream("C:\\SeleniumFiles\\MobilesList.xlsx");
	Workbook workbook = WorkbookFactory.create(fis);
	Sheet sheet = workbook.getSheet("Sheet2");
	int totalRow=sheet.getLastRowNum();
	for(int i=1;i<=totalRow;i++)
	{
		try {
		data=sheet.getRow(i).getCell(0).toString();
		if(data.equals(expectedTestCase))
		{
			flag=true;
			data1=sheet.getRow(i).getCell(1).toString();
			data2=sheet.getRow(i).getCell(2).toString();
			data3=sheet.getRow(i).getCell(3).toString();
			data4=sheet.getRow(i).getCell(4).toString();

		}
	}
		catch (Exception e) {}
	}
	if(flag==true)
	{
		System.out.println(data1);
		System.out.println(data2);
		System.out.println(data3);
		System.out.println(data4+" not ");
	}
	else
	{
		System.out.println(expectedTestCase+" is not available");
	}
	workbook.close();
}
}
