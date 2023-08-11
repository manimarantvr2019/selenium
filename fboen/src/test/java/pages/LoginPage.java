package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import common.SeleniumGenerics;

public class LoginPage extends SeleniumGenerics {

	public WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}

	// WebElements
	@FindBy(id= "email")
	public WebElement Email;
	
	@FindBy(id="pass")
	public WebElement password;
	
	@FindBy(xpath="//button[@name='login']")
	public WebElement loginbutton;
	
	public void enterEmail(String value ) 
	{
		enterText(Email, value);
	}
	
	public void enterPassword(String value ) 
	{
		enterText(password, value);
	}
	
	public void clickLogin() throws Exception  
	{
	
		//click(loginbutton);
		loginbutton.click();
	}
	
	

}
