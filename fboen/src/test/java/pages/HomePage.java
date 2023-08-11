package pages;

import org.openqa.selenium.WebDriver;

import common.PrintUtils;
import common.ResultClass;
import common.SeleniumGenerics;

public class HomePage extends SeleniumGenerics{

	private WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void verifyHomePageTitle(String expTitle) 
	{
		String actualValue = getTitle(driver);
		if(actualValue.equals(expTitle)) 
		{
			PrintUtils.logMessage("Page title matched "+ expTitle);
			ResultClass.testStatus(true);
			
		}else 
		{
			PrintUtils.logError("Page title not matched :: Actual title "+ actualValue +":: Expvalue:: "+ expTitle);
			ResultClass.testStatus(false);
		}
	}
	
}
