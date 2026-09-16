package sept14_TestNG;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	
	WebDriver driver;
	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy (className = "")  WebElement classname;
	@FindBy (name = "") WebElement name;
	@FindBy (tagName = "") WebElement tagname;
	@FindBy (id = "") WebElement id;
	@FindBy (linkText = "") WebElement linktext;
	@FindBy (partialLinkText = "") WebElement partiallinktext;
	@FindBy (css = "") WebElement css;
	@FindBy (xpath = "") List <WebElement> xpath;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
