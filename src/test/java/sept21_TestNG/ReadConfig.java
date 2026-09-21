package sept21_TestNG;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	//create object of Properties class
	Properties properties;
	String configFilePath = "";
	
	public ReadConfig() 
	{
		try {
			properties = new Properties();
			FileInputStream fis = new FileInputStream(configFilePath);
			properties.load(fis);
		}
		catch(Exception e) {

		}
		
	}
	
	
	//create method for browser and baseUrl key
	public String getBrowser() 
	{
		String value = properties.getProperty("browser");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("browser is not spacified in config.properties class");
	}
	
	
	public String getBaseUrl()
	{
		String value = properties.getProperty("baseUrl");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("baseUrl is not spacified in config.properties class");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
