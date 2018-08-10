package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AssignLeavePage {
	
	final WebDriver driver;
	
	public AssignLeavePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how = How.XPATH, using = "//a[@id='menu_leave_viewLeaveModule']")
	public static WebElement viewLeaveModule;
	//
	
	
	@FindBy(how=How.ID, using = "menu_leave_assignLeave")
	public static WebElement AssignLeave;
	
	//assignleave_txtEmployee_empName
	
	@FindBy(how=How.ID, using = "assignleave_txtEmployee_empName")
	public static WebElement EmpName;
	
	@FindBy(how=How.ID, using = "assignleave_txtLeaveType")
	public static WebElement LeaveType;
	
	@FindBy(how = How.XPATH, using = "//div[@id='assignleave_leaveBalance']")
	public static WebElement leavebal;  //getText();
	
	//assignleave_txtFromDate
	@FindBy(how=How.ID, using = "assignleave_txtFromDate")
	public static WebElement leaveFromDate;
	
	@FindBy(how=How.ID, using = "assignleave_txtToDate")
	public static WebElement leaveToDate;
	
	//assignleave_txtComment
	@FindBy(how=How.ID, using = "assignleave_txtComment")
	public static WebElement leaveComment;
	
	//assignBtn
	@FindBy(how=How.ID, using = "assignBtn")
	public static WebElement AssignButton;
	
	//confirmOkButton
	@FindBy(how=How.ID, using = "confirmOkButton")
	public static WebElement confirmbutton;
	
	//selenium hq
}
