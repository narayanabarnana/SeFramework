package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DealsPage {
	
final WebDriver driver;
	
	public DealsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
//	@FindBy(how = How.XPATH, using = "//table[@class='datacard']//tr")
//	public static List<WebElement> WebTable_productsrow;
	
	@FindBy(how = How.XPATH, using = "//table[@class='datacard']//tbody//tr")
	public static List<WebElement> WebTable_productsrow;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Deals')]")
	public static WebElement btn_Deals;
	
	////a[contains(text(),'New Contact')]
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Products')]")
	public static WebElement btn_Products;
	
	////i[@class='fa fa-money' and @title='Deals']
	@FindBy(how = How.XPATH, using = "//i[@class='fa fa-money' and @title='Deals']")
	public static List<WebElement> link_Deals;
	
	
	

}
