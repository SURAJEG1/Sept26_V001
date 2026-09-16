package sept13_TestNG;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class DynamicSearchAndDropdownList {

	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	
	
	@Test
	public void dynamicSearchAndDropdownListExample1() throws InterruptedException 
	{
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("mobile");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List <WebElement> dynamicList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='s-heavy']")));
		System.out.println("Total count of :" + dynamicList.size());
		
		for(WebElement element:dynamicList) 
		{
			System.out.println(element.getText());
			
			if(element.getText().equals("phone under 30000")) 
			{
				element.click();
				break;
			}
		}
	}
	
	
	
	
	@Test
	public void dynamicSearchDropdownListExample2() throws InterruptedException 
	{
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("mobile");
		
		Thread.sleep(2000);
		List <WebElement> dynamicList = driver.findElements(By.xpath("//span[@class='s-heavy']"));
		System.out.println("Total Count : " + dynamicList.size());
		
		for(int i=0; i<=dynamicList.size(); i++) 
		{
			System.out.println(dynamicList.get(i).getText());
			if(dynamicList.get(i).getText().contains("phone under 30000")) 
			{
				dynamicList.get(i).click();
				break;
			}
		}
	}
	
	
	
	
	
	
	@Test
	public void dynamicSearchDropdownListExample3() throws InterruptedException 
	{
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("mobile");
		Thread.sleep(2000);
		List <WebElement> dynamicList = driver.findElements(By.xpath("//span[@class='s-heavy']"));
		Thread.sleep(2000);
		int count = dynamicList.size();
		System.out.println("Total count is : " + count);
		dynamicList.get(5).click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException 
	{
		driver.close();
	}
	
	
	
	
	
}
