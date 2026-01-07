package assignment;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LoopTest 
{
public static void main(String[] args) 
{
	WebDriver d=new ChromeDriver();
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	d.get("https://demoapps.qspiders.com/ui/dropdown?sublist=0");
	WebElement dd = d.findElement(By.xpath("//label[text()='Country Code']/following-sibling::select"));
	Select s=new Select(dd);
	s.selectByIndex(1);
}
}
