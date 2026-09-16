package sept01_TestNG;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtility {
	
	//create static object of ExtentReports class
	public static ExtentReports report;
	
	public ExtentReports getExtentReport() 
	{
		if(report == null) 
		{
			String reportpath = System.getProperty("user.dir") + "/reports/extent-report.html";
			File reportFolder = new File(System.getProperty("user.dir") + "/reports");
			
			if(!reportFolder.exists()) 
			{
				reportFolder.mkdirs();
			}
			
			ExtentSparkReporter spark = new ExtentSparkReporter(reportpath);
			spark.config().setReportName("");
			spark.config().setDocumentTitle("");
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setTimeStampFormat("");
			
			report = new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("", "");
			report.setSystemInfo("", "");
			report.setSystemInfo("", "");
			report.setSystemInfo("", "");
		}
		
		return report;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
