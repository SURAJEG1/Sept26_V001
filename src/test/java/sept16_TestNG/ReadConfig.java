package sept16_TestNG;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	//create object of properties class
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
	
	
	
	//create methods for browser and baseUrl key.
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
