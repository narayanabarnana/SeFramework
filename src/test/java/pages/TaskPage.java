package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TaskPage {
	
	
	final WebDriver driver;
	
	public TaskPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Tasks')]")
	public static WebElement btn_Tasks;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'New Task')]")
	public static WebElement btn_NewTask;

	@FindBy(how = How.XPATH, using = "//input[@type='text' and @name='sequence']")
	public static WebElement taskno;
	
	////input[@type='text' and @name='title']
	@FindBy(how = How.XPATH, using = "//input[@type='text' and @name='title']")
	public static WebElement edit_title;
	
	////select[@name='status']
	@FindBy(how = How.XPATH, using = "//select[@name='status']")
	public static WebElement dropdown_status;
	
	////input[@name='completion']
	@FindBy(how = How.XPATH, using = "//select[@name='status']")
	public static WebElement edit_completion;
	
	////select[@name='task_type']
	@FindBy(how = How.XPATH, using = "//select[@name='task_type']")
	public static WebElement dropdown_tasktype;
	
	@FindBy(how = How.XPATH, using = "//select[@name='priority']")
	public static WebElement dropdown_priority;
	
	@FindBy(how = How.XPATH, using = "//input[@name='prospect_lookup' and @type='text']")
	public static WebElement edit_deal;
	
	@FindBy(how = How.XPATH, using = "//input[@name='case_lookup' and @type='text']")
	public static WebElement edit_case;
	
	////select[@name='assigned_to_user_id']
	
	@FindBy(how = How.XPATH, using = "//select[@name='assigned_to_user_id']")
	public static WebElement dropdown_assignid;
	
	@FindBy(how = How.XPATH, using = "//input[@type='checkbox' and @name='email_notification']")
	public static WebElement checkbox_emailnotification;
	
	@FindBy(how = How.XPATH, using = "//input[@type='text' and @name='contact_lookup']")
	public static WebElement edit_contact;
	
	@FindBy(how = How.XPATH, using = "//input[@type='text' and @name='client_lookup']")
	public static WebElement edit_company;
	
	@FindBy(how = How.XPATH, using = "//input[@type='text' and @name='identifier']")
	public static WebElement edit_identifier;
	
	@FindBy(how = How.XPATH, using = "//select[@name='owner_user_id' and @id='owner_user_id']")
	public static WebElement dropdown_ownerid;
	
	@FindBy(how = How.XPATH, using = "//textarea[@name='description' and @id='description']")
	public static WebElement edit_description;
	
	////input[@type='submit' and @value=" = SUBMIT = "]
//	@FindBy(how = How.XPATH, using = "//input[@type='submit' and @value=" = SUBMIT = "]")
//	public static WebElement btn_save;
}
