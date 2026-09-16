package sept01_TestNG;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.naming.directory.NoSuchAttributeException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class BaseClass {
	
	//create object of ReadConfig class
	ReadConfig readconfig = new ReadConfig();
	String browser = readconfig.getBrowser();
	String baseUrl = readconfig.getBaseUrl();
	
	public static WebDriver driver;
	@BeforeClass
	public void setup() 
	{
		switch(browser.toLowerCase()) 
		{
		case "chrome":
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;

		case "edge":
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;

		default :
			driver = null;
			break;
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@AfterClass
	public void teardown() 
	{
		driver.close();
		driver.quit();
	}
	
	
	
	public void explicitWait() 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> dynamic = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("")));
		
	}
	
	
	public void fluentWait() 
	{
		Wait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchAttributeException.class);
		
		WebElement dynamic = wait.until(ExpectedConditions.elementToBeClickable(By.id("")));
	}
	
	
	
	
	public void windowHandles() 
	{
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		
		String parent = it.next();
		String child = it.next();
		
		driver.switchTo().window(parent);
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(child);
		System.out.println(driver.getTitle());
	}
	
	
	
	public void pageScrollDown() 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
