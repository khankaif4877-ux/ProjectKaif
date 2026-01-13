package assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class GenericForLastClick {
@Test
public void genericTest()
{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("file:///C:/Users/afzau/OneDrive/Desktop/Batch_Preparation/hover_sequence.html");
	List<By> buttons = Arrays.asList(
            By.id("a"),
            By.id("b"),
            By.id("c"),
            By.id("d")
    );
	clickOnD(driver, buttons);
	handleMultipleWind(driver);
}

public void clickOnD(WebDriver driver,List<By> list)
{
	Actions act=new Actions(driver);
	for (int i=0;i<list.size();i++) {
		WebElement button=driver.findElement(list.get(i));
		if(i<list.size()-1) {
			act.moveToElement(button).perform();
		}
		else {
			act.click(button).perform();
		}
	}
}
public void handleMultipleWind(WebDriver driver)
{
	String parentWid = driver.getWindowHandle();
	Set<String> allWid = driver.getWindowHandles();
	for (String string : allWid) {
		if(!string.equals(parentWid)) {
			driver.switchTo().window(string);
			System.out.println(driver.getTitle());
			driver.close();
			driver.switchTo().window(parentWid);
			System.out.println(driver.getTitle());
		}
	}
}
}
