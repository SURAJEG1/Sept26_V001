package sept14_TestNG;

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
	
	
	
	@Test(dataProvider = "credential")
	public void doLogin(String un, String pwd) 
	{
		WebElement textUsername  = driver.findElement(By.id(""));
		WebElement textPassword  = driver.findElement(By.id(""));
		WebElement btnLogin  = driver.findElement(By.id(""));
		
		textUsername.sendKeys(un);
		textPassword.sendKeys(pwd);
		btnLogin.click();
	}
	
	
	
	
	
	
	
	@DataProvider(name = "credential")
	public Object[][] dataDriven() throws IOException
	{
//		Object[][] data = new Object[2][2];
//		data[0][0] = "";
//		data[0][1] = "";
//		
//		data[1][0] = "";
//		data[1][1] = "";
//		
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
