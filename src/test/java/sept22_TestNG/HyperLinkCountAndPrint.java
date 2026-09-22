package sept22_TestNG;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class HyperLinkCountAndPrint {
	
	
	WebDriver driver;
	@BeforeClass
	public void setup() 
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	
	
	@Test
	public void  hyperLinkCount() 
	{
		List <WebElement> hyperLinks = driver.findElements(By.tagName("a"));
		int count = hyperLinks.size();
		System.out.println(count);
		
		for(WebElement element:hyperLinks) 
		{
			System.out.println(element.getText());
		}
	}
	
	
	
	
	
	
	
	
	
	@AfterClass
	public void tearDown() 
	{
		driver.close();
	}
	
	
	

}
