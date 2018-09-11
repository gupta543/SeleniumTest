package runClasses;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageClasses.DealerPortalPage;
import pageClasses.LoginPage;
import utilities.BaseTest;
import utilities.ExtentReportManager;

public class DealerPortalDashboard extends BaseTest{
	
	ExtentTest logger; 
	//WebDriverWait wait = new WebDriverWait(driver, 20);
	private static ExtentReports reports = ExtentReportManager.invokeExtentReport();
	
	@Test(priority=0)
	public void dp_Login() throws InterruptedException{
		logger = reports.startTest("VerifyLogin");
		String usr_name = testData.get("User Name");
		String usr_pwd = testData.get("Password");
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.enterDealerID(usr_name);
		login.enterDealerPassword(usr_pwd);
		login.dpClickLogin();
		System.out.println("Login to Dealer Portal is successful");
		logger.log(LogStatus.PASS, "Login Successful");
		//System.out.println("Selenium-Maven-Git-Jenkins Integration successful");
	}
	
	@Test(priority=1)
	public void dp_Dashboard(){
		logger = reports.startTest("DealerDashboard");
		//String fmcID = "Pa-05769-1002";
		DealerPortalPage dpPage = PageFactory.initElements(driver, DealerPortalPage.class);
		dpPage.clickPencilIcon(driver);
		System.out.println("Click on particular icon is successful");
		logger.log(LogStatus.PASS, "Click on particular icon is successful");
	}
	
	public static void tearReport(ExtentReports report, ExtentTest test){
		report.endTest(test);
		report.flush();
		}
	
	@AfterMethod
	public void afterMethod(ITestResult testResult) {
	       int status = testResult.getStatus();
	       switch (status) {
	       case ITestResult.FAILURE:
	    	   	logger.log(LogStatus.FAIL, "Failed");
	    	  	 tearReport(reports, logger);
	              break;
	       case ITestResult.SUCCESS:
	               tearReport(reports, logger);
	              break;

	       }      
	 }
}
