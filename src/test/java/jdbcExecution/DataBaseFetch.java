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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.mysql.cj.jdbc.Driver;

public class DataBaseFetch 
{
public static void main(String[] args) throws SQLException {
	String projectId="";
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	Connection con = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/ninza_hrm", "root@%", "root");
	Statement stat = con.createStatement();
	ResultSet result = stat.executeQuery("select * from project;");
	while(result.next())
	{
		System.out.println("hi");
		projectId = result.getString(1);
		break;
	}
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
	d.findElement(By.cssSelector("input[placeholder='Search by Project Id']")).sendKeys(projectId,Keys.ENTER);
	String projectname= d.findElement(By.xpath("//tr/td[1]")).getText();
	System.out.println(projectname);
	con.close();
	d.quit();
}
}
