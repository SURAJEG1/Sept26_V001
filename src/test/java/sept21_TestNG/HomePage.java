package sept21_TestNG;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//create object of WebDriver intrface
	WebDriver driver;
	//parameterize constructor
	public HomePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy (name = "") WebElement proname;
	@FindBy (className = "") WebElement classname;
	@FindBy (id = "") WebElement idoflogo;
	@FindBy (linkText = "") WebElement links;
	@FindBy (tagName = "") WebElement tagname;
	@FindBy (partialLinkText = "") WebElement userid;
	@FindBy (css = "") List <WebElement> pass;
	@FindBy (xpath = "") List <WebElement> email;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
