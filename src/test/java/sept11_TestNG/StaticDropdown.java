package sept11_TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class StaticDropdown {
	
	WebDriver driver;
	@BeforeMethod
	public void setup() 
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	
	@Test
	public void staticDropdownSelectByValue() 
	{
		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
		Select sc = new Select(dropdown);
		sc.selectByValue("search-alias=nowstore");
	}
	
	@Test
	public void staticDropdownSelectByIndex() 
	{
		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
		Select sc = new Select(dropdown);
		sc.selectByIndex(5);
	}
	
	@Test
	public void staticDropdownSelectByVisibleText() 
	{
		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
		Select sc = new Select(dropdown);
		sc.selectByVisibleText("Amazon Fresh");
	}
	
	@Test
	public void staticDropdownSelectBySendKeysAction() 
	{
		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
		dropdown.sendKeys(Keys.ARROW_DOWN);
		dropdown.sendKeys(Keys.ARROW_DOWN);
		dropdown.sendKeys(Keys.ARROW_DOWN);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() 
	{
		driver.close();
	}
	
	

}
