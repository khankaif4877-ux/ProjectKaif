package com.Akshay.testYantra;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataOnExcelFile(String sheetName,int row,int cell) throws Throwable {
		FileInputStream fis = new FileInputStream("./foldername/filename");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row rw = sheet.getRow(row);
		String data = rw.getCell(cell).toString();
		return data;
		
		}
	public void getWriteBackDataOnExcelFile(String sheetName, int row,int cell) throws Throwable {
		FileInputStream fis = new FileInputStream("./foldername/filename");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row rw = sheet.getRow(row);
		Cell cel = rw.createCell(cell);
		cel.setCellValue("value");
		cel.setCellType(CellType.STRING);
		FileOutputStream fos = new FileOutputStream("./foldername/filename");
		workbook.write(fos);
		workbook.close();
		
		
		
		
	}
	

}
