package sept21_TestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class CheckBoxesSelection {
	
	WebDriver driver;
	public void  setup() 
	{
		
	}
	
	
	
	public void selectOnlyFistThreeCheckBox_Example1() 
	{
		List <WebElement> checkBoxes = driver.findElements(By.xpath(""));
		for(int i=0; i<=3; i++) 
		{
			if(!checkBoxes.get(i).isSelected()) 
			{
				checkBoxes.get(i).click();
			}
		}
	}
	
	
	
	public void  selectAllCheckboxes_Example2() 
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
	
	
	
	public void selectCheckboxesBasedOnCondition_Example3() 
	{
		List <WebElement> checkBoxes = driver.findElements(By.xpath(""));
		for(WebElement element:checkBoxes) 
		{
			String value = element.getAttribute("href");
			if(value.equals("java") && ! element.isSelected()) 
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
