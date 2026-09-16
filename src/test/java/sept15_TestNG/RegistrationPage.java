package sept15_TestNG;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	
	WebDriver driver;
	//parameterize Constructor
	public RegistrationPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy (name = "") WebElement nameElement;
	@FindBy (className = "") WebElement classname;
	@FindBy (id = "") WebElement idlocator;
	@FindBy (tagName = "") List <WebElement> tagnameLocator;
	@FindBy (linkText = "") WebElement linktextLocator;
	@FindBy (partialLinkText = "") WebElement partiallinktextLocator;
	@FindBy (css = "") WebElement csslocator;
	@FindBy (xpath = "") WebElement xpathLocator;
	
	
	
	
	public void firstname(String fName) 
	{
		nameElement.sendKeys(fName);
	}
	
	
	public void lastname(String lName) 
	{
		xpathLocator.sendKeys(lName);
	}
	
	public void usernamee(String un) 
	{
		csslocator.sendKeys(un);
	}
	
	
	public void textEmailID(String email) 
	{
		partiallinktextLocator.sendKeys(email);
	}
	
	
	public void btn(String click) 
	{
		idlocator.sendKeys(click);
	}
	
	
	
	
	
	
	

}
