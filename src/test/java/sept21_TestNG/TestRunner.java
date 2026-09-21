package sept21_TestNG;

import org.testng.annotations.Test;

public class TestRunner extends BaseClass{
	
	
	@Test
	public void searchItems() 
	{
		driver.get(baseUrl);
		maximizedWindow();
		pageScrollDown();
		refreshPage();
		implicitlyWait();
		explicitWait();
		fluentWait();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
