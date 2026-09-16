package sept09_TestNG;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class DynamicSearch {
	
	WebDriver driver;
	@BeforeMethod
	public void setup() 
	{
		ChromeOptions co = new ChromeOptions();
		co.addArguments("");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	
	@Test
	public void dynamicSearchAndListDropdownExample1() 
	{
		WebElement serachBox = driver.findElement(By.id("twotabsearchtextbox"));
		serachBox.sendKeys("pen");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		List <WebElement> dynamicList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='s-heavy']")));
		
		System.out.println("Total Count of Elements : " + dynamicList.size());
		
		for(WebElement element:dynamicList) 
		{
			System.out.println(element.getText());
			
			if(element.getText().equals("drive 128")) 
			{
				element.click();
				break;
			}
		}
	}
	
	
	
	@Test
	public void dynamicSearchAndListDropdownExample2()
	{
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("pen");
		
		List <WebElement> dynamicList = driver.findElements(By.xpath("//span[@class='s-heavy']"));
		System.out.println("Total count of Elements : " + dynamicList.size());
		
		for(int i=0; i<=dynamicList.size(); i++) 
		{
			System.out.println(dynamicList.get(i).getText());
			
			if(dynamicList.get(i).getText().contains("drive 128")) 
			{
				dynamicList.get(i).click();
				break;
			}
		}
		
	}
	
	
	
	
	
	@Test
	public void example3() 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
		searchBox.sendKeys("pen");
		
		Wait <WebDriver> fWait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(Exception.class);
		List <WebElement> dynamicList = fWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='s-heavy']")));
		int count = dynamicList.size();
		System.out.println("Total count of element : " + count);
		dynamicList.get(5).click();
	}
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() 
	{
		driver.close();
	}
	
	
	

}
