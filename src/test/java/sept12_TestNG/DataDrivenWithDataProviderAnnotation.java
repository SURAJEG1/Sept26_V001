package sept12_TestNG;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class DataDrivenWithDataProviderAnnotation {
	
	WebDriver driver;
	@BeforeMethod
	public void setup() 
	{
		ChromeOptions co = new ChromeOptions();
		// 1. Add headless argument (use "--headless=new" for modern versions of Chrome)
		co.addArguments("--headless=new");
		// Optional but highly recommended arguments for stability in background environments:
        co.addArguments("--window-size=1920,1080"); // Ensures elements are positioned correctly
        co.addArguments("--disable-gpu");         // Disables hardware acceleration
        co.addArguments("--no-sandbox");          // Overcomes OS security restrictions in Docker/CI pipelines
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	
	@Test(dataProvider = "credential")
	public void searchProd(String items) throws InterruptedException 
	{
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys(items);
		searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
	}
	
	
	
	
	
	@DataProvider(name = "credential")
	public Object[][] dataDriven() throws IOException
	{
//		Object[][] data = new Object[2][1];
//		data[0][0] = "pendrive";
//		data[1][0] = "lunchbox";
		
//		return data;
		
		//excelDriven
		String fileName = "E:\\InfoEge Automation Project\\Sept26_V001\\ExcelFolder\\Login.xlsx";
		String sheetName = "Sheet1";
		return ReadExcelUtility.excelDriven(fileName, sheetName);
		
		
	}
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() 
	{
		driver.close();
	}
	
	
	
	

}
