package sept15_TestNG;

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

public class BrokenLink {
	
	WebDriver driver;
	@BeforeClass
	public void setup() 
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	
	
	@Test
	public void getBrokenLinkCountAndUrlPrint() 
	{
		List <WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of links are.. " + links.size());
		
		List <String> urlList = new ArrayList<String>();
		
		for(WebElement link:links) 
		{
			String url = link.getAttribute("href");
			urlList.add(url);
		}
		
		long startTime = System.currentTimeMillis();
		urlList.parallelStream().forEach(link -> checkBrokenLink(link));
		long endTime = System.currentTimeMillis();
		System.out.println("Tatal time taken" + (endTime-startTime));
		
	}
	
	
	
	
	
	
	public void checkBrokenLink(String listUrl) 
	{
		try {
			URL url = new URL(listUrl);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setConnectTimeout(5000);
			httpUrlConnection.connect();

			if(httpUrlConnection.getResponseCode() >= 400) 
				System.out.println(listUrl + "--->" + httpUrlConnection.getResponseMessage() + "is a broken link");
			else
				System.out.println(listUrl + "--->" + httpUrlConnection.getResponseMessage());
		}
		catch(Exception e) {

		}
	}
	
	
	
	
	
	
	
	
	
	
	@AfterClass
	public void tearDown() 
	{
		driver.close();
		driver.quit();
	}
	
	
	
	
	

}
