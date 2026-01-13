package practice;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeOne {
public static void main(String[] args) throws InterruptedException 
{
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.google.com");
	driver.switchTo().activeElement().sendKeys("akshay kumar", Keys.ENTER);
//	driver.switchTo().newWindow(WindowType.TAB);
//	driver.get("https://www.amazon.in");
//	String amazonWid = driver.getWindowHandle();
//	driver.switchTo().newWindow(WindowType.TAB);
//	driver.get("https://www.myntra.com");
//	driver.switchTo().newWindow(WindowType.TAB);
//	driver.get("https://www.meesho.com");
//	driver.switchTo().window(amazonWid);
}
}
