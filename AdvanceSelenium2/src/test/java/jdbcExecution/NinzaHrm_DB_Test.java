package jdbcExecution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;


public class NinzaHrm_DB_Test 
{
public static void main(String[] args) throws SQLException, InterruptedException 
{
	String projectName="TekMum1";
	final Map<String, Object> chromePrefs = new HashMap<>();
	chromePrefs.put("credentials_enable_service", false);
	chromePrefs.put("profile.password_manager_enabled", false);
	chromePrefs.put("profile.password_manager_leak_detection", false); // <======== This is the important one

	final ChromeOptions chromeOptions = new ChromeOptions();
	chromeOptions.setExperimentalOption("prefs", chromePrefs);
	WebDriver d=new ChromeDriver(chromeOptions);
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	d.get("http://49.249.28.218:8091/");
	d.findElement(By.id("username")).sendKeys("rmgyantra");
	d.findElement(By.id("inputPassword")).sendKeys("rmgy@9999",Keys.ENTER);
	d.findElement(By.linkText("Projects")).click();
	d.findElement(By.xpath("//span[text()='Create Project']")).click();
	d.findElement(By.name("projectName")).sendKeys(projectName);
	d.findElement(By.name("createdBy")).sendKeys("haque");
	WebElement dd = d.findElement(By.xpath("//form[@action]//select[@name='status']"));
	Select s=new Select(dd);
	s.selectByVisibleText("Created");
	d.findElement(By.cssSelector("input[value='Add Project']")).click();
	d.findElement(By.cssSelector("input[placeholder='Search by Project Id']")).sendKeys(projectName,Keys.ENTER);
	String projectId = d.findElement(By.xpath("//tr/td[1]")).getText();
	
	//db validation..........
	
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	Connection con = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/ninza_hrm", "root@%", "root");
	Statement stat = con.createStatement();
	ResultSet result = stat.executeQuery("select * from project where project_id='"+projectId+"';");
	while(result.next())
	{
		System.out.println(result.getString(1));
		System.out.println(result.getString(2));
		System.out.println(result.getString(3));
		System.out.println(result.getString(4));

	}
	
	//delete project....
	int updateResult = stat.executeUpdate("delete from project where project_id='"+projectId+"';");
	System.out.println(updateResult);
	con.close();
	d.navigate().refresh();
	Thread.sleep(2000);
	d.findElement(By.cssSelector("input[placeholder='Search by Project Id']")).sendKeys(projectName,Keys.ENTER);
	System.out.println("done");

	

}
}
