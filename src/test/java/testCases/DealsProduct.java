package testCases;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import dataProvider.ExcelDataConfig;
import pages.DealsPage;
import utility.BaseExtentTest;
import utility.Highlight;

public class DealsProduct extends BaseExtentTest{

	static DealsPage dealspage;
	static ExcelDataConfig excel = new ExcelDataConfig("C:\\Users\\Nbarnana\\Desktop\\TestData.xlsx");
	
	@SuppressWarnings("static-access")
	@Test()
	public static void DealsProductWebTable() throws InterruptedException
	{
		
		dealspage=PageFactory.initElements(driver, DealsPage.class);
		
		driver.switchTo().frame("mainpanel");
		
		Highlight.highLightElement(driver, dealspage.btn_Deals);
		Actions action=new Actions(driver);
		action.moveToElement(dealspage.btn_Deals).build().perform();
				
		
		Thread.sleep(5000);
		
		Highlight.highLightElement(driver, dealspage.btn_Products);
		dealspage.btn_Products.click();
		
		Highlight.highLightListElement(driver, dealspage.WebTable_productsrow);
		
	}


}
