package sept15_TestNG;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

		case "firefox":
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;

		default :
			driver = null;
			break;
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	
	@AfterClass
	public void tearDown() 
	{
		driver.close();
	}
	
	
	public void maximizeWindow() 
	{
		driver.manage().window().maximize();
	}
	
	public void refreshWindow() 
	{
		driver.navigate().refresh();
	}
	
	public void pageScrollDown() 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(300,document.body.windowHeight)");
	}
	
	public void windowHandles() 
	{
		Set <String> window = driver.getWindowHandles();
		Iterator <String> it = window.iterator();
		
		String patent = it.next();
		String child = it.next();
		
		driver.switchTo().window(patent);
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(child);
		System.out.println(driver.getTitle());
	}
	
	
	public void implicitWait() 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void  explicitWait() 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement textUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
		textUsername.sendKeys("surajpatil.ok@gmail.com");
	}
	
	
	public void fluentWait() 
	{
		Wait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(Exception.class);
		List <WebElement> textEm = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@text()='']")));
	}
	
	
	
	
	
	

}

