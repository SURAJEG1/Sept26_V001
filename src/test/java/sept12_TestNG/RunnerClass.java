package sept12_TestNG;

import org.testng.annotations.*;

public class RunnerClass extends BaseClass{
	
	
	
	
	@Test
	public void doLogin() 
	{
		driver.get(baseUrl);
		maximize();
		implicitWait(10);
		explicitWait();
		fluentWait();
		pageScrollDown();
		windowHandles();
		
		LoginPage lp = new LoginPage(driver);
		lp.username("welcome@gmail.com");
		lp.hyperLink();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
