package com.Aarati.ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver=null;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}
	
	@FindBy(name="user_name")
	public WebElement username;
	
	@FindBy(name="user_password")
	public WebElement password;
	
	@FindBy(id="submitButton")
	public WebElement login;
	
	public void loginToApp()
	{
		
		driver.get("http://49.249.28.218:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		username.sendKeys("admin");
		password.sendKeys("admin");
		login.click();
	}
}
