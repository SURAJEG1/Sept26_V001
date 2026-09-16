package sept16_TestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class CheckBox {
	
	WebDriver driver;
	@BeforeMethod
	public void setup() 
	{
		
	}
	
	
	
	public void selectCheckBox_Example1() 
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
	
	
	
	public void selectCheckBox_Example2() 
	{
		List <WebElement> checkBoxes = driver.findElements(By.xpath(""));
		for(WebElement element:checkBoxes) 
		{
			if(!element.isSelected()) 
			{
				element.click();
			}
		}
	}
	
	
	
	public void selectCheckBox_Example3() 
	{
		List <WebElement> checkBoxes = driver.findElements(By.xpath(""));
		for(WebElement element:checkBoxes) 
		{
			String value = element.getAttribute("value");
			if(value.equals("Java") && ! element.isSelected())
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
