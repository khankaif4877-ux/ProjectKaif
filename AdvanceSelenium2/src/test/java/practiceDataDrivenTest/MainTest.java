package practiceDataDrivenTest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MainTest 
{
	@Parameters("browser")
	@Test
public void readXmlDataTest(String browser) 
{
	System.out.println("browser is ==> "+browser);
	System.out.println("ugjugjyugjg");
}
}
