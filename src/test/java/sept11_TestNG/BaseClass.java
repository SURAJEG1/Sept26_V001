package sept11_TestNG;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
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
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	//create object of ReadConfig class
	ReadConfig readconfig = new ReadConfig();
	String browser = readconfig.getBrowser();
	String baseUrl = readconfig.getBaseUtl();
	
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
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	
	public void maximizedWindow()
	{
		driver.manage().window().maximize();
	}
	
	
	public void pageScrollDown() 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(400, document.body.windowHeight)");
	}
	
	
	public void pageRefresh() 
	{
		driver.navigate().refresh();
	}
	
	
	public void screenshot() throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		String timestamp  = new SimpleDateFormat("yyyyMMdd_HHssMM").format(new Date());
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("");
		FileUtils.copyFile(source, destination);
	}
	
	
	
	public void implicitWait(int wait) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
	}
	
	
	public void explicitWait() 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("")));
	}
	
	
	public void fluentWait() 
	{
		Wait<WebDriver> fWait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(Exception.class);
		List <WebElement> dynamicList = fWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("")));
	}
	
	
	
	
	
	

}
