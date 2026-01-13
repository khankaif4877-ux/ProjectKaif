package practiceDataDrivenTest;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataInXml 
{
@Test
public void sampleTest(XmlTest test)
{
	System.out.println("class 1");
	System.out.println(test.getParameter("browser"));
	System.out.println(test.getParameter("url"));
	System.out.println(test.getParameter("username"));
	System.out.println(test.getParameter("password"));
}
}
