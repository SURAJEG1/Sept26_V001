package sept07_TestNG;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RagistrationPage {
	
	WebDriver driver;
	public RagistrationPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy (id = "")WebElement id;
	@FindBy (name = "") List<WebElement> name;
	
	
	
	
	public void login(String userId) 
	{
		id.sendKeys(userId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
