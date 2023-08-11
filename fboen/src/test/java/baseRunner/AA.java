package baseRunner;

import org.openqa.selenium.By;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AA extends Baseclass {
	@DataProvider(name="amazondetail")
	private Object[][] data() {
		return new Object[][] {
			{"football"},
			{"iphone"},
			{"watchmen"},
			{"laptops"}
		};

	}
	@Test(dataProvider="amazondetail")
	private void te2(String se) throws AWTException {
		launchbrowser();
		System.out.println(Thread.currentThread().getId());
		launchurl("https://www.amazon.in/");
		Windowmaximize();
		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		searchbox.sendKeys(se);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		String pt = pagetitle();
		System.out.println(pt);
		
	}
	@Test(enabled = false)
	private void te3() {
		System.out.println("testcast 3");
		launchurl("https://www.amazon.in/");
		
}
	@Test
	private void te4() {
		System.out.println("testcast 4");
		
}
	@Test(invocationCount = 2)
	private void te5() {
		System.out.println("testcast 5");
//		launchurl("https://www.facebook.com/");
		
}
}
