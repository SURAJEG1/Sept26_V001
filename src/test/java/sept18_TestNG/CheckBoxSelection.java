package sept18_TestNG;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class CheckBoxSelection {
	
	
	
	WebDriver driver;
	@BeforeClass
	public void setup() 
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	
	public void checkBoxesSelectExample1() 
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
	
	
	
	
	
	public void checkBoxesSelectExample2() 
	{
		List <WebElement> checkBoxes = driver.findElements(By.id(""));
		for(WebElement element:checkBoxes) 
		{
			if(!element.isSelected())
			{
				element.click();
			}
		}
	}
	
	
	
	public void checkBoxesSelectExample3() 
	{
		List <WebElement> checkBoxes = driver.findElements(By.cssSelector(""));
		for(WebElement element:checkBoxes) 
		{
			String value = element.getAttribute("href");
			if(value.equals("shoes") && ! element.isSelected()) 
			{
				element.click();
			}
		}
	}
	
	
	
	
	
	
	
	
	

}
