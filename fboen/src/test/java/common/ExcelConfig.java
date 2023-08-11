package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.SkipException;

public class ExcelConfig {


	public static String SheetName;
	public static String WorkBookName;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet ;

	public static String TestCaseName;
	public static String TestDesc;
	public static String TestDatas;
	public static  String TestRun;
	public static String updateTestcaseName;


	public static HashMap<String, String> hmap;

	public static  void setWorkbookAndSheetName(String workbook, String sheetName) throws Exception
	{
		WorkBookName =workbook;
		SheetName=sheetName;
		System.out.println("Workbook and SheetName is :: " + WorkBookName +"##"+SheetName);

		File file = new File(workbook);
		FileInputStream fis = new FileInputStream(file);

		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);


	}

	public static void readTestData(String testcaseNames) 
	{
		for(int i=1;i<=sheet.getLastRowNum(); i++)
		{

			TestCaseName= sheet.getRow(i).getCell(0).getStringCellValue();
			updateTestcaseName=TestCaseName;
			if(TestCaseName.equals(testcaseNames))
			{
				TestRun= sheet.getRow(i).getCell(3).getStringCellValue();
				if(TestRun.toUpperCase().equals("YES"))
				{
				TestDesc= sheet.getRow(i).getCell(1).getStringCellValue();
				TestDatas= sheet.getRow(i).getCell(2).getStringCellValue();
				splitTestDatas(TestDatas);
				ExtentReport.setTestName(TestCaseName, TestDesc);
				break;
				}
				else 
				{
					throw new SkipException("Run Mode Set to No for the testcase - please verify TestDatas in Excel");
				}
				
			}			
		}
	}

	public static  void updateStatusInExcel() throws Exception
	{
		try {
			
			File file = new File(WorkBookName);
			FileInputStream fis = new FileInputStream(WorkBookName);

			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet(SheetName);
			for(int i=1; i<=sh.getLastRowNum(); i++)
			{
				try
				{	
					TestCaseName= sh.getRow(i).getCell(0).getStringCellValue();	
					
					if(TestCaseName.equalsIgnoreCase(updateTestcaseName))
					{
						if(ResultClass.excelResultStaus.contains(false))
						{	
							sh.getRow(i).getCell(4).setCellValue("FAIL");

						}else
						{
							sh.getRow(i).getCell(4).setCellValue("PASS");
						}
						
						if(ResultClass.excelResultStaus.isEmpty())
						{
							sh.getRow(i).getCell(4).setCellValue("Skipped");
						}
						fis.close();
						FileOutputStream outFile =new FileOutputStream(new File(WorkBookName));
						wb.write(outFile);
						outFile.close();
						break;
					}	
				}
				catch (Exception e)
				{
					e.printStackTrace();
					System.out.println("Unable to Update Result to Testcase Name :: "+TestCaseName);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void splitTestDatas(String TestDatas) 
	{
		hmap = new HashMap();
		for(int i =0; i< TestDatas.split("@@").length; i++)
		{
			String data = TestDatas.split("@@")[i];

			for(int j=0; j<data.split("##").length; j++)
			{
				String key = data.split("##")[0];
				String value = data.split("##")[1];

				hmap.put(key, value);
			}
		}
	}

	


}





















