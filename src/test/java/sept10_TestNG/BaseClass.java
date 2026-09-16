package sept10_TestNG;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	//create object of ReadConfig class
	ReadConfig readconfig = new ReadConfig();
	String browser = readconfig.getBrowser();
	String baseUrl = readconfig.getBaseUrl();
	
	
	public static WebDriver driver;
	@BeforeTest
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
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	
	
	public void maximizeWindow() 
	{
		driver.manage().window().maximize();
	}
	
	
	public void implicitWait(int wait) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
	}
	
	public void explicitWait() 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("")));
		Select sc = new Select(dropdown);
		sc.selectByIndex(4);
	}
	
	
	public void fluentWait() 
	{
		Wait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(Exception.class);
		WebElement btnLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
	}
	
	
	
	public void pageScrollDown() 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(400,document.body.scrollHeight)");
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
	
	
	public void screenshot() throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		String timestamp  = new SimpleDateFormat("yyyyMMdd_HHssMM").format(new Date());
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destinaiton = new File("");
		FileUtils.copyFile(source, destinaiton);
	}
	
	
	
	
	
	
	

}
