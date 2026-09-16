package sept05_TestNG;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BrokenLink {
	
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
	public void getBrokenLinks() 
	{
		HttpURLConnection huc = null;
		List allHyperlinksList = driver.findElements(By.tagName("a"));

		for (Object hyperLink : allHyperlinksList) {
			String url = ((WebElement)hyperLink).getAttribute("href");

			try {
				URL actualUrl = new URL(url);
				huc = (HttpURLConnection) actualUrl.openConnection();
				huc.setRequestMethod("HEAD");
				huc.connect();

				int respCode = huc.getResponseCode();

				if (respCode == 400) {
					System.out.println(url + " is a BROKEN link");
				} else {
					System.out.println(url + " is a VALID link");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterClass
	public void tearDown() 
	{
		driver.close();
	}
	
	
	
	

}
