package practiceDataDrivenTest;

import org.testng.annotations.Test;

public class ReadRunTimeDataTest
{
@Test
public void runTimeParameterTest()
{
//	String url=System.getProperty("url");
//	System.out.println("URL is ==> "+url);
//	String browser=System.getProperty("browser");
//	System.out.println("browser is ==> "+browser);
//	String username=System.getProperty("username");
//	System.out.println("username is ==> "+username);
	String password=System.getProperty("password");
	System.out.println("password is ==> "+password);
}

}