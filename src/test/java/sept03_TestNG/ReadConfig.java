package sept03_TestNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	
	//create object of Properties class
	Properties properties;
	String configFile = "";
	
	//constructor
	public ReadConfig() 
	{
		try {
			properties = new Properties();
			FileInputStream fis = new FileInputStream(configFile);
			properties.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//create method for browser and baseUrl key;
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
