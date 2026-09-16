package sept11_TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Iframe {
	
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
	public void iframe() 
	{
		driver.switchTo().frame("");
		System.out.println("switched to ifame...");

		WebElement textMobNo = driver.findElement(By.xpath(""));
		WebElement btnOTP = driver.findElement(By.xpath(""));

		textMobNo.sendKeys("421343214");
		btnOTP.click();
		
		driver.switchTo().defaultContent();
		System.out.println("Switched back to default....");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterClass
	public void tearDown() 
	{
		driver.close();
	}
	
	
	

}
