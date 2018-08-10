package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utility.Highlight;

public class CRMLoginPage {
	
	static WebDriver driver;
	
	public CRMLoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how = How.NAME, using = "username")
	public static WebElement txtbx_UserName;
	
	@FindBy(how = How.NAME, using = "password")
	public static WebElement txtbx_Password;
	
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	public static WebElement LoginButton;
	
	public static void CRMLogin(String user, String Password){
		
		Highlight.highLightElement(driver, txtbx_UserName);
		txtbx_UserName.sendKeys(user);
		
		Highlight.highLightElement(driver, txtbx_Password);
		txtbx_Password.sendKeys(Password);
		
		Highlight.highLightElement(driver, LoginButton);
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", LoginButton);
		//LoginButton.click();
	}

}