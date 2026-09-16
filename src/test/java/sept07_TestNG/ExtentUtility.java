package sept07_TestNG;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentUtility {
	
	//create static object of ExtentReports class
	public static ExtentReports report;
	
	
	public ExtentReports getExtentReport() 
	{
		if(report==null) 
		{
			String reportpath = System.getProperty("user.dir") + "reports/extent-report.html";
			File reportFolder = new File(System.getProperty("user.dir") + "/reports");
			
			if(!reportFolder.exists())
			{
				reportFolder.mkdirs();
			}
			
			ExtentSparkReporter spark = new ExtentSparkReporter(reportpath);
			spark.config().setReportName("Automation Test Result");
			spark.config().setDocumentTitle("Extent Report");
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setTimeStampFormat("");
			
			report = new ExtentReports();
			report.attachReporter(spark);;
			report.setSystemInfo("Tester", "Suraj");
			report.setSystemInfo("OS", "Windows11");
			report.setSystemInfo("Browser", "Chrome");
			report.setSystemInfo("Machine", "Tester LP");
			
		}
		
		return report;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
