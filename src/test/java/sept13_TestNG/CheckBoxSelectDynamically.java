package sept13_TestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;


/*
Explanation:
findElements() returns all matching checkboxes as a List.
The for loop goes through each checkbox.
isSelected() checks whether it is already selected.
click() selects it only if it isn't selected.
*/


public class CheckBoxSelectDynamically {
	
	WebDriver driver;
	@BeforeMethod
	public void setup() 
	{
		
	}
	
	
	
	//Select only the first 3 checkboxes.
	public void checkBoxSelect_Example1() 
	{
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

		for (int i = 0; i < 3; i++) {
		    if (!checkboxes.get(i).isSelected()) {
		        checkboxes.get(i).click();
		    }
		}
	}
	
	
	
	//Select all checkboxes.
	public void checkBoxSelect_Example2() 
	{
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

		for (WebElement checkbox : checkboxes) {
		    if (!checkbox.isSelected()) {
		        checkbox.click();
		    }
		}
	} 
	

	
	//Select checkboxes based on a condition
	public void checkBoxSelect_Example3() 
	{
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

		for (WebElement checkbox : checkboxes) {
		    String value = checkbox.getAttribute("value");

		    if (value.equals("Java") && !checkbox.isSelected()) {
		        checkbox.click();
		    }
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
