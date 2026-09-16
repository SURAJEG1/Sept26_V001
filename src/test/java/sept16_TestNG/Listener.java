package sept16_TestNG;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener{
	
	
	WebDriver driver;
	
	public void onTestStart(ITestContext context) 
	{
		System.out.println(context.getName() + "test started..");
	}
	
	
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println(result.getName() + "successfully executed...");
	}
	
	
	public void onTestFailure(ITestResult result) 
	{
		try {
			System.out.println(result.getName() + "got failed and screenshot captured...");
			System.out.println(result.getThrowable());

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
