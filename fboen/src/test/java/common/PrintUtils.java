package common;

import org.testng.Reporter;

public class PrintUtils {

	
	public static void logMessage(String msg)
	{
		System.out.println(msg);
		Reporter.log(msg);	
		ExtentReport.testStep(msg, "PASS");
	}
	
	
	public static void logError(String msg)
	{
		System.err.println(msg);
		Reporter.log(msg);	
		ExtentReport.testStep(msg, "FAIL");
	}
}
