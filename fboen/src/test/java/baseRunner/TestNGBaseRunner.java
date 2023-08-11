package baseRunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.AppConfig;
import common.ExcelConfig;
import common.ExtentReport;
import common.Extentreporters;
import common.ReadProperties;
import common.ResultClass;
import pages.PageComponents;


public class TestNGBaseRunner {
  
	
	private WebDriver driver =null;
	public PageComponents _pagecompenets;
	public AppConfig config;
	public ReadProperties _readProp;
	
	public String AppURL;
	Extentreporters va = new Extentreporters();
	@Test
	@BeforeSuite
	public void beforeSuite() 
	{
		_readProp = new ReadProperties(System.getProperty("user.dir")+"/app.properties");
		System.out.println(_readProp);
		 AppURL= _readProp.getKey("URL");
		 
		 //extentreport
		 va.startreport();
	}
	
	@BeforeTest
	public void start() throws Exception  
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mani\\eclipse-workspace\\fboen\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		setDriver(driver);

		// getter setter
		config = new AppConfig();
		config.setApplicationURL(AppURL);
		driver.get(config.getApplicationURL());
		
		System.out.println(driver);
		
		_pagecompenets = new PageComponents(driver);
		
		// Login to application
		//ExtentReport.setTestName("Login", "Login to application");
		va.setTestName("login", "maran", "smoke test");
		_pagecompenets._loginpage.enterEmail(_readProp.getKey("UserName"));
		_pagecompenets._loginpage.enterPassword(_readProp.getKey("Password"));
		_pagecompenets._loginpage.clickLogin();
		//ExtentReport.endReport();
		//va.status(null);
		va.endreport();
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		ResultClass.callSoftAssert();
		driver.navigate().to(config.getApplicationURL());
	}
	
	@AfterMethod
	public void afterMethod() throws Exception
	{
		// update test status in Excel 
		ExcelConfig.updateStatusInExcel();
		// clear list 
		ResultClass.excelResultStaus.clear();
		//Clear Hashmap
		ExcelConfig.hmap.clear();
	}
	
	@AfterTest
	public void end() 
	{
		driver.quit();
		va.status(null);
		va.endreport();
		
		//ExtentReport.endReport();
		
	}
	
	public WebDriver getDriver() 
	{
		return driver;
	}

	public void setDriver(WebDriver driver)
	{
		System.out.println(driver);
		this.driver = driver;
	}
	
}
