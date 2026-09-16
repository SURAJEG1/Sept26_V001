package sept10_TestNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	//create object of Properties class
	Properties properties;
	String configPath = "";
	
	public ReadConfig() 
	{
		try {
			properties = new Properties();
			FileInputStream fis = new FileInputStream(configPath);
			properties.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//create methods for browser and base Url key
	public String getBrowser() 
	{
		String value = properties.getProperty("browser");
		if(value!=null) 
			return value;
		else
			throw new RuntimeException("browser is not spacified in config.properties file");
	}
	
	
	public String getBaseUrl() 
	{
		String value = properties.getProperty("baseUrl");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("baseUrl is not spacified in config.properties file"); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
