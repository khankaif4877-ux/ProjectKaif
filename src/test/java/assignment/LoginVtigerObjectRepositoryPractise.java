package assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.Aarati.ObjectRepository.LoginPage;

public class LoginVtigerObjectRepositoryPractise {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		LoginPage log=new LoginPage(driver);
		log.loginToApp();
		

	}

}
