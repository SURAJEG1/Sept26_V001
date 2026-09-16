package sept12_TestNG;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//create object of WebDriver interface
	WebDriver driver;
	
	//parameterize constructor
	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy (className = "") 
	WebElement textUsername;
	
	@FindBy (tagName = "a")
	List <WebElement> link;
	
	
	public void username(String un) 
	{
		textUsername.sendKeys(un);
	}
	
	public void hyperLink() 
	{
		link.size();
		for(WebElement element:link) 
		{
			String url = element.getAttribute("href");
			System.out.println(url);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

