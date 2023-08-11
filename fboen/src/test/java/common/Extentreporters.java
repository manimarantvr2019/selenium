package common;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreporters {
	ExtentReports exte;
	 ExtentTest t1;
	public void  startreport() {
		//blank html page
		ExtentSparkReporter report = new ExtentSparkReporter("./fbreport.html");
		//attach the details
		 exte =  new ExtentReports();
		exte.attachReporter(report);
		}
	
	public  void setTestName(String testCaseName, String author,String category ) 
	{
		
		 t1 = exte.createTest(testCaseName);
		 t1.assignAuthor(author);
		 t1.assignCategory(category);
		//t1 = extent.startTest(testCaseName, testDescription);
	}
   public void status(ITestResult result)
    {
    	if (result.getStatus()== ITestResult.SUCCESS)
		{
			t1.pass("test case is pass");
		}
		else if (result.getStatus()== ITestResult.FAILURE)
		{
			t1.fail("test is fail");
		}
		else if (result.getStatus()== ITestResult.SKIP)
		{
			t1.info("test is info");
		}
    	
    	
    }
    public void endreport() 
	{
		exte.flush();
	}
    
	
//	t1.pass("just");
//	t1.fail("fail",MediaEntityBuilder.createScreenCaptureFromPath(null).build));
}
