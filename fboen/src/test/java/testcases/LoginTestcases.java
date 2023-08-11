package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseRunner.TestNGBaseRunner;
import common.ExcelConfig;
import common.PrintUtils;
import common.ResultClass;


public class LoginTestcases extends TestNGBaseRunner {

	@BeforeClass
	public void BeforeClass() throws Exception 
	{
		ExcelConfig.setWorkbookAndSheetName("./TestData/TestDatas.xlsx", "Login");
	}
	
	@Test(priority=1)
	public void validateLoginFunctionality() throws Exception 

	{
		ExcelConfig.readTestData("validateLoginFunctionality");
		
		PrintUtils.logMessage("validateLoginFunctionality testcase started");
		try
		{
			_pagecompenets._homepage.verifyHomePageTitle(ExcelConfig.hmap.get("ExpectedValue"));		
		}
		catch(Exception ex)
		{
			PrintUtils.logError("Exception block called inside testcase" + ex.getMessage());
			ResultClass.testStatus(false);
		}
		finally 
		{
			ResultClass.assertAll();
		}

	}


	@Test(priority=2)
	public void validateForgetLink() 

	{
		ExcelConfig.readTestData("validateForgetLink");
		try {
			PrintUtils.logMessage("validateForgetLink testcase started");
			String a = ExcelConfig.hmap.get("ExpectedValue");
			PrintUtils.logMessage("Expected title from excel is ::" +a );
			_pagecompenets._forgetpasswordpage.clickForgetLinkAndVerifyTitle(a);
			
    		}
			catch(Exception ex)
			{
				PrintUtils.logError("Exception block called inside testcase" + ex.getMessage());
				ResultClass.testStatus(false);
			}
			finally 
			{
				ResultClass.assertAll();
			}
		}

	}