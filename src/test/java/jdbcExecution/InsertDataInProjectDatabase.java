package jdbcExecution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.jdbc.Driver;

public class InsertDataInProjectDatabase 
{
@SuppressWarnings("unlikely-arg-type")
public static void main(String[] args) throws SQLException 
{
	String projectNewName="insta09878";
	Connection con=null;
	try 
	{
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	con = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
	Statement stat = con.createStatement();
	int updateResult = stat.executeUpdate("insert into project values('a6','deepak','morning','insta09878',' ',1);");
	System.out.println(updateResult);
	}
	catch (Exception e) {
		System.out.println("handled");
	}
	finally {
		con.close();
		System.out.println("connection closed.");
	}
	
	//verifying in application
	
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.get("http://106.51.90.215:8084/");
	driver.findElement(By.id("username")).sendKeys("rmgyantra");
	driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	driver.findElement(By.cssSelector("button[type='submit']")).submit();
	driver.findElement(By.xpath("//a[text()='Projects']")).click();
	driver.findElement(By.cssSelector("input[placeholder='Search by Project Id']")).sendKeys("insta");
	
	List<WebElement> allProjectNames = driver.findElements(By.xpath("//div/table//tr/td[1]"));
	wait.until(ExpectedConditions.visibilityOfAllElements(allProjectNames));
	for(WebElement projectName:allProjectNames)
	{
		String projectText=projectName.getText();
		if(projectNewName.equals(projectText))
		{
			System.out.println(projectNewName+" project is created successfully : passed.");
		}
	}
}
}
