package sept11_TestNG;

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
		driver.get("https://www.amazon.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	
	
	@Test
	public void hyperLinCount() throws InterruptedException 
	{
		Thread.sleep(4000);
		List <WebElement> hyperLink = driver.findElements(By.tagName("a"));
		System.out.println("Total count of hyperLink : " + hyperLink.size());
		
		for(WebElement element:hyperLink) 
		{
			//System.out.println(element.getText());
			System.out.println(element.getAttribute("href"));
		}
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	
	
	
	
	
	
	

}
