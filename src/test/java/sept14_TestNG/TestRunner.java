package sept14_TestNG;

import org.testng.annotations.Test;

public class TestRunner extends BaseClass{
	
	
	@Test
	public void doLogin() 
	{
		driver.get(baseUrl);
		implicitWait(10);
		explicitWait();
		fluentWait();
		pageScrollDown();
		windowHandles();
		
		//create Object of LoginPage class
		LoginPage lp = new LoginPage(driver);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
