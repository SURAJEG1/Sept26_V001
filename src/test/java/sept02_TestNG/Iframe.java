package sept02_TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class Iframe {
	
	
	WebDriver driver;
	@BeforeClass
	public void setup() 
	{
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--incognito");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	
	@Test
	public void iframe() 
	{
		driver.switchTo().frame("");
		System.out.println("Swithc to iframe...");
		
		WebElement textPhoneNo = driver.findElement(By.xpath(""));
		textPhoneNo.sendKeys("10101010");
		
		WebElement btnOTP = driver.findElement(By.xpath(""));
		btnOTP.click();
		
		driver.switchTo().defaultContent();
		System.out.println("switch back to default...");
	}
	
	
	
	
	
	

	
	
	
	@AfterClass
	public void tearDown() 
	{
		driver.close();
	}
	
	
	
	

}
