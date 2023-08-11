package baseRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.FileOutputStream;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver;
	
	 public static void launchbrowser() {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 }
	 public static void Windowmaximize() {
		 driver.manage().window().maximize();
	 }
	 public static void launchurl(String url) {
		 driver.get(url);
	 }
	 public static String pagetitle() {
		 String title = driver.getTitle();
		 System.out.println(title);
		 return title;
	 }
	 public static String currenturl() {
		 String curl = driver.getCurrentUrl();
		 System.out.println(curl);
		 return curl;
	 }
	 public static void passtext(String txt,WebElement ele) {
		 ele.sendKeys(txt);
	 }
	 public static void closeEntirebrowser() {
		 driver.quit();
	 }
	 public static void clickbtn(WebElement ele) {
		 ele.click();
	 }
	 public static void screenshot(String imgname) throws IOException
	 {
		 TakesScreenshot ts =((TakesScreenshot)driver);
	     //step2
	     File img = ts.getScreenshotAs(OutputType.FILE);
         //step3
	     File f = new File("location + imgname.png");
        //step4
	     FileUtils.copyFile(img, f);
	 }
	 public static Actions a;
	 public static void passtext(WebElement targetwebelement) {
		 a = new Actions(driver);
		 a.moveToElement(targetwebelement).perform();
	 }
	 public static void passtext(WebElement dragelement ,WebElement dropelement) {
		 a = new Actions(driver);
		 a.dragAndDrop(dragelement, dropelement).perform();
	 }
	 public static JavascriptExecutor js;
	 public static void scrollup(WebElement tarwebe) {
		 js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView(true)", tarwebe);
	 }
	 public static void scrolldown(WebElement tarwebelement) {
		 js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView(false)", tarwebelement);
	 }
	 public static void excelRead(String sheetname,int rowno,int colno) throws IOException {
		 File f = new File("C:\\Users\\Mani\\eclipse-workspace\\mavendata\\excel\\details.xlx.xlsx");
	         FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet s1 = wb.getSheet("details");
			Row r1 = s1.getRow(rowno);
			Cell c1 = r1.getCell(colno);
			int ty = c1.getCellType();
			String value4 = " ";
					
			if(ty==1) 
			{
				String st = c1.getStringCellValue();
				System.out.println(st); 
			}
			else if(DateUtil.isCellDateFormatted(c1)) {
				Date d = c1.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				String value = dateFormat.format(d);
				System.out.println(value);
			}
			else {
				double d = c1.getNumericCellValue();
				long l = (long)d;
				String value1 = String.valueOf(l);
				System.out.println(value1); 
			}
			}
			public static void createnewexcel(int nrowno,int celno,String writedata) throws IOException {
				
				 File f = new File("C:\\\\Users\\\\Mani\\\\eclipse-workspace\\\\mavendata\\\\excel\\\\m1.xlsx");
		        // FileInputStream fis = new FileInputStream(f);
				Workbook wb = new XSSFWorkbook();
				Sheet s2 = wb.createSheet("detail");
				Row r2= s2.createRow(nrowno);
				Cell c = r2.createCell(celno);
				c.setCellValue(writedata);
				FileOutputStream rfos = new FileOutputStream(f);
				wb.write(rfos);
			    
	 }
			public static void createcell(int getrowno,int celno,String credata) throws IOException
			{ File f = new File("C:\\\\\\\\Users\\\\\\\\Mani\\\\\\\\eclipse-workspace\\\\\\\\mavendata\\\\\\\\excel\\\\\\\\m1.xlsx");
	         FileInputStream fis = new FileInputStream(f);
			Workbook wbo = new XSSFWorkbook(fis);
			Sheet s3 = wbo.getSheet("detail");
			Row r3= s3.createRow(getrowno);
			Cell c2 = r3.createCell(celno);
			c2.setCellValue(credata);
			FileOutputStream rfos = new FileOutputStream(f);
			wbo.write(rfos);
				
			}
			

			public static void createrow(int crerowno,int celno,String credata) throws IOException
			{ File f = new File("C:\\\\Users\\\\Mani\\\\eclipse-workspace\\\\mavendata\\\\excel\\\\m1.xlsx");
	         FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet s2 = wb.getSheet("detail");
			Row r2= s2.createRow(crerowno);
			Cell c3 = r2.createCell(celno);
			c3.setCellValue(credata);
			FileOutputStream rfos = new FileOutputStream(f);
			wb.write(rfos);
				
			}
			

}
