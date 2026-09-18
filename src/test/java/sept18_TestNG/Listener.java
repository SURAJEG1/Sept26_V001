package sept18_TestNG;

import org.testng.*;
import org.testng.ITestListener;

public class Listener implements ITestListener{
	
	
	public void onTestStart(ITestContext context) 
	{
		System.out.println(context.getName() + "Test Case Start...");
	}
	
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println(result.getMethod().getMethodName() + "Successfully Executed...");
	}
	
	public void onTestFailure(ITestResult result) 
	{
		System.out.println(result.getMethod().getMethodName() + "got failed and screenshot captured...");
		System.out.println(result.getThrowable());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
