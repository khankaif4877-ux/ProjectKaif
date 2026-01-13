package practiceDataDrivenTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UpdateInProperties 
{
public static void main(String[] args) throws IOException 
{
	FileInputStream fis=new FileInputStream("./data/PracticePropertiesFile.txt");
	Properties p=new Properties();
	p.load(fis);
	String br = p.getProperty("browser");
	System.out.println(br);
	p.setProperty("browser", "edge");
	System.out.println(p.getProperty("browser"));
	String br2 = p.getProperty("browser");
	System.out.println(br2);
}
}