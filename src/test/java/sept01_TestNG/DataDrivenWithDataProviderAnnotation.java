package sept01_TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class DataDrivenWithDataProviderAnnotation {
	//create object of WebDriver interface
	
	WebDriver driver;
	@BeforeMethod
	public void setup() 
	{
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--incongnito");
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	
	@Test(dataProvider = "items")
	public void searchProd(String prod) 
	{
		WebElement searchBox = driver.findElement(By.id(""));
		searchBox.sendKeys(prod);
		searchBox.sendKeys(Keys.ENTER);
	}
	
	
	@DataProvider(name = "items")
	public Object[][] dataDriven()
	{
		Object[][] data = new Object[2][1];
		
		data[0][0] = "";
		data[1][0] = "";
		
		return data;
	}
	
	
	
	
	@AfterMethod
	public void tearDown() 
	{
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
