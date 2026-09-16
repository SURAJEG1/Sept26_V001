package sept14_TestNG;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import org.testng.ITestListener;

public class Listener implements ITestListener{
	
	WebDriver driver;
	
	public void onTestStart(ITestContext context) 
	{
		System.out.println(context.getName() + " Test Case Start...");
	}
	
	
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println(result.getName() + " Successfully executed...");
	}
	
	
	public void onTestFailure(ITestResult result) 
	{
		System.out.println(result.getName() + "Got failed & Screenshot captured...");
		System.out.println(result.getThrowable());
		
		try {
		TakesScreenshot ts = (TakesScreenshot)driver;
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHssMM").format(new Date());
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("");
		FileUtils.copyFile(source, destination);
		}
		catch(Exception e) {
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
