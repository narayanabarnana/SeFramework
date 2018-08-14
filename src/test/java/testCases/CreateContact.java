package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import ImplementedClassLib.CheckboxControl;
import ImplementedClassLib.DropdownControl;
import ImplementedClassLib.TextboxControl;
import ImplementedClassLib.WebElementControl;
import dataProvider.ExcelDataConfig;
import pages.CRMLoginPage;
import pages.ContactPage;
import utility.BaseExtentTest;
import utility.Highlight;

public class CreateContact extends BaseExtentTest{
	
	
	static CRMLoginPage Login;
	static ContactPage contactpage;
	
	static ExcelDataConfig excel = new ExcelDataConfig("C:\\Users\\Nbarnana\\Desktop\\TestData.xlsx");
	
	@SuppressWarnings("static-access")
	@Test
	public static void CRMCreateContact() throws Exception
	{
		
		contactpage=PageFactory.initElements(driver, ContactPage.class);
		WebElementControl webelementcontrol = new WebElementControl();
		TextboxControl textbox=new TextboxControl();
		DropdownControl dropdown=new DropdownControl();
		CheckboxControl checkbox=new CheckboxControl();
		
		driver.switchTo().frame("mainpanel");
		
		Highlight.highLightElement(driver, contactpage.btn_Contacts);
		Actions action=new Actions(driver);
		action.moveToElement(contactpage.btn_Contacts).build().perform();
		Thread.sleep(5000);
		
		Highlight.highLightElement(driver, contactpage.btn_NewContact);
		webelementcontrol.click(contactpage.btn_NewContact);
		
		Highlight.highLightElement(driver, contactpage.dropdown_Title);
		dropdown.selectViaValue(contactpage.dropdown_Title, "Mr.");
		
		Highlight.highLightElement(driver, contactpage.edit_FirstName);
		textbox.setText(contactpage.edit_FirstName, "Narayana");
		
		Highlight.highLightElement(driver, contactpage.edit_MiddleName);
		textbox.setText(contactpage.edit_MiddleName, "Nari");
		
		Highlight.highLightElement(driver, contactpage.edit_SurName);
		textbox.setText(contactpage.edit_SurName, "B");
		
		Highlight.highLightElement(driver, contactpage.dropdown_suffix);
		dropdown.selectViaValue(contactpage.dropdown_suffix, "MD");
		
		Highlight.highLightElement(driver, contactpage.edit_NickName);
		textbox.setText(contactpage.edit_NickName, "Nari");
		
		Highlight.highLightElement(driver, contactpage.edit_Company);
		textbox.setText(contactpage.edit_Company, "WellsFargo");
		
		driver.findElements(By.xpath("//form//td//input[@type='submit']")).get(0).click();
		
		
		
		
		
		
	}

}
