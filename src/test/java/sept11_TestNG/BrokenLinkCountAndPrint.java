package sept11_TestNG;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.*;

public class BrokenLinkCountAndPrint {
	
	WebDriver driver;
	@BeforeClass
	public void setup() 
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	
	@Test
	public void getBrokenLinkCoutnAndPrint() 
	{
		List <WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of links are " + links.size());
		
		List <String> urlList = new ArrayList <String>();
		
		for(WebElement element:links) 
		{
			String url = element.getAttribute("href");
			urlList.add(url);
			//checkBrokenLink(url);
		}
		
		long startTime = System.currentTimeMillis();
		urlList.parallelStream().forEach(element ->  checkBrokenLink(element));
		long endTime = System.currentTimeMillis();
		
		System.out.println("Total time taken : " + (endTime-startTime));
	}
	
	
	
	
	
	
	public void checkBrokenLink(String linkUrl) 
	{
		try {
			//create object of URL class
			URL url = new URL(linkUrl);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setConnectTimeout(5000);
			httpUrlConnection.connect();
			
			if(httpUrlConnection.getResponseCode() >=400) 
			{
				System.out.println(linkUrl + "--->" + httpUrlConnection.getResponseMessage() + " is a broken link...");
			}
			else
			{
				System.out.println(linkUrl + "--->" + httpUrlConnection.getResponseMessage());
			}
		}
		catch(Exception e) {
		}
	}
	
	
	
	
	
	
	
	
	
	
	@AfterClass
	public void tearDown() 
	{
		driver.close();
	}
	
	
	
	
	

}
