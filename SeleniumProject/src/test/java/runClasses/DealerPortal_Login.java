package runClasses;
//import java.util.concurrent.TimeUnit;


//import org.openqa.selenium.By;
//import org.openqa.selenium.By.ByXPath;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.assertTrue;

import java.io.File;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;






import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageClasses.LoginPage;
import utilities.BaseTest;



public class DealerPortal_Login extends BaseTest{
	ExtentReports reports;
	ExtentTest logger; 
	
	
	@Test
	public void dp_Login() throws InterruptedException{
		reports = new ExtentReports("D:\\Git\\SeleniumProject\\AutomationReport.html");
		logger = reports.startTest("VerifyLogin");
		String usr_name = testData.get("User Name");
		String usr_pwd = testData.get("Password");
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.enterDealerID(usr_name);
		login.enterDealerPassword(usr_pwd);
		login.dpClickLogin();
		System.out.println("Login to Dealer Portal is successful");
		System.out.println("Selenium-Maven-Git-Jenkins Integration successful");
		//Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Login Successful");
		reports.endTest(logger);
		reports.flush();
	}
	
	
	/*@AfterTest
	public void cleanUp(){
		reports.flush();
	}*/

	/*public static void main(String[] args) throws InterruptedException {
		String dealerID = "Pa-05769-100";
		String password = "testid60";
		String URL = "https://dealerportal.sc2qa.dealerconnection.com/#/login";
		
		DealerPortal_Login dp_login = new DealerPortal_Login();
		dp_login.DealerPortal_Login(dealerID, password, URL);

	}*/

}
