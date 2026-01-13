package jdbcExecution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;


public class VerifyDataInDatabaseWithGUI 
{
public static void main(String[] args) throws SQLException 
{
	//create
	Random random=new Random();
	int randomInt = random.nextInt(1000);
	String projectName="instagram111"+randomInt;
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://106.51.90.215:8084/");
	driver.findElement(By.id("username")).sendKeys("rmgyantra");
	driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	driver.findElement(By.cssSelector("button[type='submit']")).submit();
	driver.findElement(By.xpath("//a[text()='Projects']")).click();
	driver.findElement(By.xpath("//span[text()='Create Project']")).click();
	driver.findElement(By.name("projectName")).sendKeys(projectName);
	driver.findElement(By.name("createdBy")).sendKeys("deepak");
	WebElement projectStatus = driver.findElement(By.xpath("//option[text()='Select Value']/parent::select"));
	Select selectStatus=new Select(projectStatus);
	selectStatus.selectByVisibleText("Created");
	driver.findElement(By.cssSelector("input[type='submit']")).submit();
	
	//verify the project name with database
	
	Connection con=null;
	try {
	Driver driverRef=new Driver();
	DriverManager.registerDriver(driverRef);
	con = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
	Statement stat = con.createStatement();
	ResultSet result = stat.executeQuery("select * from project;");
	while(result.next())
	{
		String actualData=result.getString(4);
		if(projectName.equals(actualData))
		{
			System.out.println("project name in database is : "+actualData);
			System.out.println("created project name is: "+projectName);
			System.out.println("project is created : passed");
		}
	}
	}
	catch (Exception e) {
		System.out.println("handled");	
		}
	finally {
		con.close();
		System.out.println("connection is closed.");
	}
}
}