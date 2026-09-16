package sept16_TestNG;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	//create object of WebDriver interface
	
	WebDriver driver;
	//parameterize constructor
	public HomePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (name = "") WebElement name;
	@FindBy (id = "") WebElement id;
	@FindBy (className = "") WebElement classname;
	@FindBy (tagName = "") WebElement tagname;
	@FindBy (linkText = "") WebElement linkText;
	@FindBy (partialLinkText = "") WebElement partiallinktext;
	@FindBy (css = "") WebElement cssSelectorLocator;
	@FindBy (xpath = "") List <WebElement> xparhLocator;
	
	
	
	public void action() 
	{
		name.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
