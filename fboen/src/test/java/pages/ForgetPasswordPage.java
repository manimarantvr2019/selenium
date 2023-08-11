package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.PrintUtils;
import common.ResultClass;
import common.SeleniumGenerics;

public class ForgetPasswordPage extends SeleniumGenerics
{

	public WebDriver driver;
	
	public ForgetPasswordPage(WebDriver driver) 
	{
	 this.driver=driver;
	}
	
	@FindBy(linkText="Forgotten account?")
	public WebElement forgetLink;
	
	public void clickForgetLinkAndVerifyTitle(String ExpectedTitle) 
	{
		click(forgetLink);
		String actualTitle = getTitle(driver);
		if(actualTitle.equals(ExpectedTitle)) 
		{
			PrintUtils.logMessage("Page title matched "+ ExpectedTitle);
			ResultClass.testStatus(true);
		}else 
		{
			PrintUtils.logError("Page title not matched :: Actual title "+ actualTitle +":: Expvalue:: "+ ExpectedTitle);
			ResultClass.testStatus(false);
		}
	}
}
