package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	
	public Properties prop = new Properties();
	
	public ReadProperties(String filePath) 
	{
		
		File file = new File(filePath);
		FileInputStream fis =null;
		try {
			 fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
		
			PrintUtils.logError("Unable to load properties file :: FileNotFoundException");
		}
		
		try {
			prop.load(fis);
		} catch (IOException e)
		{
			PrintUtils.logError("IOException occured");
		}
	}
	
	public String getKey(String Key)
	{
		return prop.getProperty(Key);
	}
}
