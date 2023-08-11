package common;

import java.util.ArrayList;
import java.util.List;

import org.testng.asserts.*;

public class ResultClass {

	
 public static SoftAssert sa = null;
 
 public static List<Boolean> excelResultStaus =new ArrayList<Boolean>();
	
 
 public static void callSoftAssert() 
 {
	 sa= new SoftAssert();
 }
 
 public static void testStatus(boolean value) 
 { 
	 
	 //excel report
	 excelResultStaus.add(value);
	 
	 //testng report
	 if(value==true)
	 {
		 sa.assertTrue(value);
	 }else 
	 {
		 sa.fail();
	 } 
 }
 
 public static void assertAll() 
 {
	 sa.assertAll();
 }
 
}
