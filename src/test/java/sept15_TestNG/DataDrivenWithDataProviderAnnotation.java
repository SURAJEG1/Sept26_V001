package sept15_TestNG;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class DataDrivenWithDataProviderAnnotation {
	
	WebDriver driver;
	@BeforeMethod
	public void setup() 
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	
	
	@Test(dataProvider = "items")
	public void searchProd(String prod) 
	{
		WebElement searchBox = driver.findElement(By.id(""));
		searchBox.sendKeys(prod);
	}
	
	
	
	@DataProvider(name = "items")
	public Object[][] dataDriven() throws IOException
	{
//		Object[][] data = new Object[2][1];
//		data[0][0] = "";
//		data[1][0] = "";
//		return data;
		
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
