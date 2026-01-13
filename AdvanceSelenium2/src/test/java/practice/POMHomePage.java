package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMHomePage {
	public POMHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Products")
	private WebElement ProductLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement OrgLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement Contactlink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminimg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;

	public WebElement getProductLink() {
		return ProductLink;
	}

	public WebElement getOrgLink() {
		return OrgLink;
	}

	public WebElement getContactlink() {
		return Contactlink;
	}

	public WebElement getAdminimg() {
		return adminimg;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}
	
	
	
	
	

}
