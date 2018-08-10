package testCases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import ImplementedClassLib.ActionControl;
import ImplementedClassLib.CheckboxControl;
import ImplementedClassLib.DropdownControl;
import ImplementedClassLib.TextboxControl;
import dataProvider.ExcelDataConfig;
import pages.AddEmployeePage;
import pages.CRMLoginPage;
import pages.OrangeHRMLogin;
import pages.PersonalDetailsPage;
import pages.TaskPage;
import utility.BaseExtentTest;
import utility.Highlight;

public class CreateTask extends BaseExtentTest{

	
	
	static CRMLoginPage Login;
	static TaskPage Task;
	
	static ExcelDataConfig excel = new ExcelDataConfig("C:\\Users\\Nbarnana\\Desktop\\TestData.xlsx");
	
	@SuppressWarnings("static-access")
	@Test
	public static void CRMCreateTask() throws Exception
	{
//		Login=PageFactory.initElements(driver, CRMLoginPage.class);
		Task=PageFactory.initElements(driver, TaskPage.class);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.switchTo().frame("mainpanel");
		
		
		Highlight.highLightElement(driver, Task.btn_Tasks);
		Actions action=new Actions(driver);
		action.moveToElement(Task.btn_Tasks).build().perform();
		
		Thread.sleep(5000);
		
		Highlight.highLightElement(driver, Task.btn_NewTask);
		Task.btn_NewTask.click();
		
		
		//Printing task no
		Highlight.highLightElement(driver, Task.taskno);
		String Taskno=Task.taskno.getAttribute("value");
		System.out.println("*********** Task Number is *************" + Taskno);
		
		
		TextboxControl textbox=new TextboxControl();
		DropdownControl dropdown=new DropdownControl();
		CheckboxControl checkbox=new CheckboxControl();
		
		Highlight.highLightElement(driver, Task.edit_title);
		textbox.setText(Task.edit_title, "MR");
		//dropdown.selectViaVisibleText(Task.dropdown_tasktype, "Open");
		Highlight.highLightElement(driver, Task.dropdown_status);
		dropdown.selectViaValue(Task.dropdown_status, "Open");
		
		Highlight.highLightElement(driver, Task.edit_completion);
		textbox.setText(Task.edit_completion, "50");
		
		Highlight.highLightElement(driver, Task.edit_case);
		textbox.setText(Task.edit_case, "Test case");
		
		Highlight.highLightElement(driver, Task.dropdown_tasktype);
		dropdown.selectViaValue(Task.dropdown_tasktype, "Call");
		
		Highlight.highLightElement(driver, Task.dropdown_priority);
		dropdown.selectViaValue(Task.dropdown_priority, "High");
		
		Highlight.highLightElement(driver, Task.checkbox_emailnotification);
		checkbox.changeCheckBoxStatus(Task.checkbox_emailnotification, true);
		//Highlight.highLightElement(driver, Task.dropdown_assignid);
		//dropdown.selectViaValue(Task.dropdown_assignid, "Naveen1 K1");
		
		driver.findElements(By.xpath("//form//td//input[@type='submit']")).get(0).click();
		String finaltask=driver.findElements(By.xpath("//div[@id='vSummary']//td[@class='datacardtitle']")).get(1).getText();
		System.out.println(" Final Task Number is " + finaltask);
		
		String[] TaskNumber=finaltask.split(":");
		int n = TaskNumber.length;
		System.out.println("Length of the split function " + n);
		for(String str: TaskNumber)
		{
			System.out.println(str.replaceAll("\\s", ""));
			if(str.replaceAll("\\s", "").equalsIgnoreCase(Taskno))
			{
				assertTrue(true, "Task Number matched");
			}
			
		}
		
		//Assert.assertEquals("", , message);
		
	}
	
}
