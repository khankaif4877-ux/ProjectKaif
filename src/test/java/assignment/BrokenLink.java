package assignment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
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

public class BrokenLink 
{
    static int rowIn=1;
    static Sheet sh;
    
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
       
        WebDriver driver = new ChromeDriver();
        FileInputStream fis=new FileInputStream("./Broken/BrokenLink.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        sh = wb.getSheet("BrokenLink");
        Row row = sh.createRow(0);
        row.createCell(0, CellType.STRING).setCellValue("statement");
        row.createCell(1, CellType.STRING).setCellValue("response_Code");

        try {
            driver.get("http://www.deadlinkcity.com/"); // Replace with your URL

            // Get all links with <a> tag
            List<WebElement> links = driver.findElements(By.tagName("a"));

            System.out.println("Total links found: " + links.size());

            for (WebElement link : links) {
                String url = link.getAttribute("href");

                // Check link status
               checkLink(url);
               rowIn++;
                
            }

        } finally {
        	FileOutputStream fos=new FileOutputStream("./Broken/BrokenLink.xlsx");
        	wb.write(fos);
        	wb.close();
            driver.quit();
            System.out.println("done");
        }
    }

    public static void checkLink(String linkUrl) {
    	String res;
    	int responseCode=0;
    	String msg="";
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setConnectTimeout(3000);
            httpConn.connect();

            System.out.println(httpConn.getResponseMessage());
      
            responseCode = httpConn.getResponseCode();
            msg = httpConn.getResponseMessage();

            if (responseCode >= 400) {
                res= linkUrl + " is a broken link.";
            } else {
                res= linkUrl + " is valid.";
            }

        } catch (Exception e) {
            res=linkUrl + " is broken. Exception: " + e.getMessage();
        }
        Row row = sh.createRow(rowIn);
        row.createCell(0, CellType.STRING).setCellValue(res);
        row.createCell(1, CellType.STRING).setCellValue(responseCode+" : "+msg);
    }

}
