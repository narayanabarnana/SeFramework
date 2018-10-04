package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import ImplementedClassLib.CheckboxControl;
import ImplementedClassLib.DropdownControl;
import ImplementedClassLib.TextboxControl;
import ImplementedClassLib.WebElementControl;
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
		WebElementControl webelementcontrol = new WebElementControl();
		TextboxControl textbox=new TextboxControl();
		DropdownControl dropdown=new DropdownControl();
		CheckboxControl checkbox=new CheckboxControl();
		
		driver.switchTo().frame("mainpanel");
		
		Highlight.highLightElement(driver, dealspage.btn_Deals);
		Actions action=new Actions(driver);
		action.moveToElement(dealspage.btn_Deals).build().perform();
				
		
		Thread.sleep(5000);
		
		Highlight.highLightElement(driver, dealspage.btn_Products);
		dealspage.btn_Products.click();
		
		//Highlight.highLightListElement(driver, dealspage.WebTable_productsrow);
		List<WebElement> RowWebElement=dealspage.WebTable_productsrow;
		int rowcount = RowWebElement.size();
		System.out.println("Row Count for Webtable Products is " + rowcount);
		
		for(int i=1;i<rowcount;i++)
		{
			List<WebElement> ColRow=RowWebElement.get(i).findElements(By.xpath("td"));
			int colcount=ColRow.size();
			System.out.println("Column Count for Row " + i + " is " + colcount);
			for(int j=1;j<colcount;j++)
			{
//				
				String data=ColRow.get(i).getText();
				System.out.println(data);
//				List<WebElement> links=ColRow.get(i).findElements(By.tagName("a"));
//				int linkscount = links.size();
//				System.out.println("Links count in the webtable products is " + linkscount);
//				
//				
			}
			
		}
		
//		List<WebElement> Product_DealsElement=dealspage.link_Deals;
//		int DealsCount=Product_DealsElement.size();
//		System.out.println("Total deals links in product table " + DealsCount);
//		Product_DealsElement.get(1).click();
		
		
		
	}


}
