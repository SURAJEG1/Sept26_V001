package sept15_TestNG;

import java.io.IOException;

import org.testng.annotations.Test;

public class TestCaseRunner extends BaseClass{
	
	
	
	@Test
	public void doUserRegistration() throws IOException 
	{
		driver.get(baseUrl);
		DataDrivenWithDataProviderAnnotation dataDriven = new DataDrivenWithDataProviderAnnotation();
		dataDriven.dataDriven();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
