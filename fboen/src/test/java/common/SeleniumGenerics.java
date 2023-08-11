package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;


public class SeleniumGenerics 
{

//	public SoftAssert sa = null;
//	
//	public  void callSoftAssert() 
//	 {
//		 sa= new SoftAssert();
//	 }
//	 
//	 public  void testStatus(boolean value) 
//	 {
//		 if(value==true)
//		 {
//			 sa.assertTrue(value);
//		 }else 
//		 {
//			 sa.fail();
//		 } 
//	 }
//	 
//	 public  void assertAll() 
//	 {
//		 sa.assertAll();
//	 }
//	 
	 
	//Click webelement

	public void click(WebElement ele) 
	{
		ele.click();
		//PrintUtils.logMessage("Element Clicked");
	}
	public void clickByID(WebDriver driver , String target) 
	{
		driver.findElement(By.id(target)).click();	
		PrintUtils.logMessage("Elemet clicked by ID::" + target);
	}

	public void clickByClass(WebDriver driver , String target) 
	{
		driver.findElement(By.className(target)).click();	
		PrintUtils.logMessage("Elemet clicked by class::" + target);
	}

	public void clickByXpath(WebDriver driver , String target) 
	{
		driver.findElement(By.xpath(target)).click();	
		PrintUtils.logMessage("Elemet clicked by xpath::" + target);
	}


	//Enter Text

	public void enterText(WebElement ele, String value) 
	{
		ele.sendKeys(value);
		PrintUtils.logMessage("Entered text ::"+value);
	}
	
	public void enterTextByID(WebDriver driver, String target, String value) 
	{
		driver.findElement(By.id(target)).sendKeys(value);
		PrintUtils.logMessage("Text Entered by ID ::" + target);
	}

	public void enterTextByXPath(WebDriver driver, String target, String value) 
	{
		driver.findElement(By.xpath(target)).sendKeys(value);
		PrintUtils.logMessage("Text Entered by Xpath: " + target);
	}

	public void enterTextByClass(WebDriver driver, String target, String value) 
	{
		driver.findElement(By.className(target)).sendKeys(value);
		PrintUtils.logMessage("Text Entered by Class: " + target);
	}

	//Browser functions
	public void browserBack(WebDriver driver) 
	{
		driver.navigate().back();
	}

	public void browserForward(WebDriver driver) 
	{
		driver.navigate().forward();
	}

	public void browserRefresh(WebDriver driver) 
	{
		driver.navigate().refresh();
	}

	public String getTitle(WebDriver driver) 

	{
		String value =driver.getTitle();
		return value;

	}

	public String getCurrentUrl(WebDriver driver)

	{
		String value =driver.getCurrentUrl();
		return value;

	}

	public String getText(WebDriver driver, WebElement Element) 

	{
		String value = Element.getText();
		return value;

	}

	public String getAttribute(WebElement Element, String AttributeName) 

	{
		String AttributeValue = Element.getAttribute(AttributeName);
		return AttributeValue;

	}

	public void selectByValue(WebElement Element, String value)

	{
		Select obj = new Select(Element);
		obj.selectByValue(value);

	}

	public void selectByIndex(WebElement Element, int value)

	{
		Select obj = new Select(Element);
		obj.selectByIndex(value);

	}

	public void selectByVisibleText(WebElement Element, String value)

	{
		Select obj = new Select(Element);
		obj.selectByVisibleText(value);

	}

	public String selectByFirstSelectedOption(WebElement Element)

	{
		Select obj = new Select(Element);
		String value =obj.getFirstSelectedOption().getText();
		return value;
	}	


	public boolean isDisplayed(WebElement ele)
	{
		try {
			
			if(ele.isDisplayed());
			{
				PrintUtils.logMessage("Element displayed ::"+ ele);
			return true;
			}
			
		} catch (Exception e) 
		{
			return false;
		}
	}

	public boolean isSelected(WebElement ele) 
	{
		if(ele.isSelected())
		{
			return true;
		}else 
		{
			return false;
		}
	}

}
