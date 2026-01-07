package assignment;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromXmlFile {
@Test
	public void SampleTest(XmlTest test)
	{
		System.out.println(test.getParameter("browser"));
	}
}
