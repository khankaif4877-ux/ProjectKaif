package practiceDataDrivenTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteDataInProp {
public static void main(String[] args) throws IOException {
	FileInputStream fis=new FileInputStream("./data/PracticePropertiesFile.txt");
	Properties p=new Properties();
	p.load(fis);
	System.out.println(p.getProperty("browser"));
	p.setProperty("browser", "chrome");
	System.out.println(p.getProperty("browser"));
	p.store(new FileOutputStream("./data/PracticePropertiesFile.txt"), "done");
}
}
