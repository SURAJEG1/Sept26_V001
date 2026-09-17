package sept17_TestNG;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class CheckBoxSelect {
	
	WebDriver driver;
	@BeforeMethod
	public void setup() 
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	
	
	@Test
	public void checkBoxSelect_Example1() 
	{
		List <WebElement> checkBoxes = driver.findElements(By.xpath(""));
		for(int i=0; i<3; i++) 
		{
			if(!checkBoxes.get(i).isSelected()) 
			{
				checkBoxes.get(i).click();
			}
		}
	}
	
	
	public void checkBoxSelect_Example2() 
	{
		List <WebElement> checkBoxes =driver.findElements(By.xpath(""));
		for(WebElement element:checkBoxes) 
		{
			if(!element.isSelected()) 
			{
				element.click();
			}
		}
	}
	
	
	
	
	public void checkBoxSelect_Example3() 
	{
		List <WebElement> checkBoxex = driver.findElements(By.className(""));
		
		for(WebElement element:checkBoxex) 
		{
			String value = element.getAttribute("href");
			if(value.equals("size") && ! element.isSelected()) 
			{
				element.click();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() 
	{
		driver.close();
	}
	
	
	
	
	
	

}
