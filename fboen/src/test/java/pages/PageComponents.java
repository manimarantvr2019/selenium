package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageComponents {

	private WebDriver driver;
	public LoginPage _loginpage;
	public HomePage _homepage;
	public ForgetPasswordPage _forgetpasswordpage;
	
	
	public PageComponents(WebDriver driver) {
	
		this.driver=driver;
		_loginpage = PageFactory.initElements(this.driver, LoginPage.class);
		_homepage = PageFactory.initElements(this.driver, HomePage.class);
		_forgetpasswordpage = PageFactory.initElements(this.driver, ForgetPasswordPage.class);
		
		
	}
	
}
