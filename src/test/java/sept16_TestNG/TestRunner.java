package sept16_TestNG;

public class TestRunner extends BaseClass{
	
	
	public void doLogin() 
	{
		driver.get(baseUrl);
		maximizeWindow();
		refreshPage();
		pageScrollDown();
		implicitWait(5);
		explicitWait();
		fluentWait();
		windowHandles();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
