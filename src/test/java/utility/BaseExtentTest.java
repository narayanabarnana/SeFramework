package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.OrangeHRMHomePage;
import pages.OrangeHRMLogin;
import pages.CRMLoginPage;

public class BaseExtentTest {
	
	
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static ExtentHtmlReporter htmlReporter;
	public static OrangeHRMHomePage homepage;


	@SuppressWarnings("static-access")
	
	@BeforeClass
	public static void CRMLogin(){
		
		
		logger = extent.createTest("CRMLogin");
		//this will automatically opens the browser, maximize the browser
		driver = BrowserFactory.getBrowser("chrome");
										
		//this will provide the URL from the config.properties file
		driver.get(DataProviderFactory.getConfig().getApplicationurl());
								
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		CRMLoginPage PageLogin=PageFactory.initElements(driver, CRMLoginPage.class);
		PageLogin.CRMLogin(DataProviderFactory.getConfig().getusername(), DataProviderFactory.getConfig().getpassword());
		
		//new BaseExtentTest();
	}
	
	
	
	@BeforeSuite
	public void setUp()
	{
		htmlReporter = new ExtentHtmlReporter("./Reports/Regression.html");
		extent = new ExtentReports();
		extent.config();
		extent.attachReporter(htmlReporter);
		
		htmlReporter.config().setReportName("Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
	}
	
	
	@AfterMethod
	public void getResult(ITestResult result) throws Exception{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			System.out.println(result.getName());
			System.out.println(driver);
			String screenshotPath=GetScreenshot.capture(driver, result.getName());
			//logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "test case failed due to below issues", ExtentColor.RED));
			logger.fail(MarkupHelper.createLabel(result.getName() + "test case failed due to below issues", ExtentColor.RED));
			logger.fail(result.getThrowable());
			//String screenshotPath=GetScreenshot.capture(driver, result.getName());
			logger.fail("Screenshot below" + logger.addScreenCaptureFromPath(screenshotPath));
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass(MarkupHelper.createLabel(result.getName() + "test case Passed", ExtentColor.GREEN));
		}
		else
		{
			//logger.skip(Status.SKIP, MarkupHelper.createLabel(result.getName() + "test case Passed", ExtentColor.YELLOW));
			logger.skip(MarkupHelper.createLabel(result.getName() + "test case Skipped", ExtentColor.YELLOW));
			logger.skip(result.getThrowable());
		}
		//extent.flush();
		
	}
	
	
	@SuppressWarnings("static-access")
	@AfterClass
	public static void CloseApp() throws Exception{
		
		
		
		
		//System.out.println(driver);
		
		//driver.findElement(By.xpath("//a[@href='https://www.freecrm.com/index.cfm?logout=1']")).click();
		
		//driver.close();
		//driver.quit();
	}
	
	
	
	@AfterSuite
	public void teardown()
	{
		
		extent.flush();
		//driver.quit();
		
	}
	
	
	
	

}
