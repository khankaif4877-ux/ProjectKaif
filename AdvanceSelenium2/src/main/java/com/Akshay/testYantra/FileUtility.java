package com.Akshay.testYantra;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	public String getDataFromProperties(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./foldername/filename.properties");
		Properties p = new Properties();
		p.load(fis);
		String property=p.getProperty(key);
		return property;
	}
	

}
