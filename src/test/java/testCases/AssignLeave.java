package testCases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import dataProvider.ExcelDataConfig;
import pages.AssignLeavePage;
import utility.BaseExtentTest;
import utility.Highlight;

public class AssignLeave extends BaseExtentTest{
	
	public static AssignLeavePage leaveassign;
	static WebDriverWait waitst;
	
	static ExcelDataConfig excel = new ExcelDataConfig("C:\\Users\\Nbarnana\\eclipse-workspace\\OrangeFramework\\TestData\\OrangeHRM.xlsx");
	
	@SuppressWarnings("static-access")
	@Test
	public static void LeaveAssignment()
	{
		
		logger = extent.createTest("LeaveAssignment");
		leaveassign=PageFactory.initElements(driver, AssignLeavePage.class);
		
		Highlight.highLightElement(driver, leaveassign.viewLeaveModule);
		leaveassign.viewLeaveModule.click();
		
		
		waitst = new WebDriverWait(driver, 30);
        waitst.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_leave_assignLeave")));
		
        Highlight.highLightElement(driver, leaveassign.AssignLeave);
        leaveassign.AssignLeave.click();
		
		waitst.until(ExpectedConditions.visibilityOfElementLocated(By.id("assignleave_txtEmployee_empName")));
		Highlight.highLightElement(driver, leaveassign.EmpName);
		leaveassign.EmpName.sendKeys(excel.getCellData("Sheet1", "Emp Name", 3));
		leaveassign.EmpName.sendKeys(Keys.ENTER);
		
		//leaveassign.LeaveType.
		Highlight.highLightElement(driver, leaveassign.LeaveType);
		Select leavetypedd=new Select(leaveassign.LeaveType);
		leavetypedd.selectByVisibleText(excel.getCellData("Sheet1", "Leave Type", 3));
		
		Highlight.highLightElement(driver, leaveassign.leavebal);
		String initialleavebal=leaveassign.leavebal.getText();
		System.out.println("Initial Leave bal is "+ initialleavebal);
		
		Date myDate = new Date();
		System.out.println(myDate);
		//System.out.println(new SimpleDateFormat("MM/dd/yyyy").format(myDate));
		String DateF=new SimpleDateFormat("yyyy-MM-dd").format(myDate);
		System.out.println("The date format is " + DateF);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(myDate));
		System.out.println(myDate);
		
		Highlight.highLightElement(driver, leaveassign.leaveFromDate);
		leaveassign.leaveFromDate.clear();
		leaveassign.leaveFromDate.sendKeys(DateF);
		
		Highlight.highLightElement(driver, leaveassign.leaveToDate);
		leaveassign.leaveToDate.clear();
		leaveassign.leaveToDate.sendKeys(DateF);
		
		Highlight.highLightElement(driver, leaveassign.leaveComment);
		leaveassign.leaveComment.sendKeys(excel.getCellData("Sheet1", "LeaveComment", 3));
		
		Highlight.highLightElement(driver, leaveassign.AssignButton);
		leaveassign.AssignButton.click();
		
		Highlight.highLightElement(driver, leaveassign.confirmbutton);
		leaveassign.confirmbutton.click();
		
	}

}
