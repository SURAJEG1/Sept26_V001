package sept14_TestNG;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {
	
	
	
	WebDriver driver;
	public ScreenshotUtility(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	
	
	
	
	public void screenshot() throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHssMM").format(new Date());
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("");
		FileUtils.copyFile(source, destination);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
