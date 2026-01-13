package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SizeTest 
{
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	Point position = driver.manage().window().getPosition();
	System.out.println(position.getX());
	Thread.sleep(2000);
	Point p=new Point(0, 0);
	driver.manage().window().setPosition(p);
	Point position2 = driver.manage().window().getPosition();
	System.out.println(position2.getX()+"   "+position2.getY());
	
}
}
