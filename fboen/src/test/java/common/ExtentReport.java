package common;

import java.io.File;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {

	private static ExtentTest test;
	private static ExtentReports extent;

	public static void testStep(String desc, String status) 
	{
		if (status.toUpperCase().equals("PASS"))
		{
			test.log(LogStatus.PASS, desc);
		}
		else if (status.toUpperCase().equals("FAIL"))
		{
			test.log(LogStatus.FAIL, desc );
		}
		else if (status.toUpperCase().equals("INFO"))
		{
			test.log(LogStatus.INFO, desc);
		}
	}

	public static void startReport()
	{
		extent = new ExtentReports("./ExtentReport/AutoReport.html", true);
		extent.loadConfig(new File("./extent-config.xml"));
	}

	public static void setTestName(String testCaseName, String testDescription ) 
	{
		test = extent.startTest(testCaseName, testDescription);
	}

	public static void endReport() 
	{
		extent.endTest(test);
		extent.flush();
	}
}
