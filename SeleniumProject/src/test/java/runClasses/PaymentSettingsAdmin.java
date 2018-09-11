package runClasses;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageClasses.LoginPage;
import pageClasses.PaymentPage;
import utilities.BaseTest;
import utilities.CaptureScreenshot;

public class PaymentSettingsAdmin extends BaseTest{
	
	CaptureScreenshot cs = new CaptureScreenshot();
	//private String browserName;
	//@Parameters("browserName")
	@Test(priority = 0)
	public void dp_Login() throws InterruptedException, IOException{
		
		String usr_name = testData.get("User Name");
		String usr_pwd = testData.get("Password");
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.enterDealerID(usr_name);
		login.enterDealerPassword(usr_pwd);
		login.dpClickLogin();
		System.out.println("Login to Dealer Portal is successful");
		cs.captureScreenshot(driver);
		System.out.println("Screenshot is captured successfully");
		
		
		
		//System.out.println("Selenium-Maven-Git-Jenkins Integration successful");
	}
	
	@Test(priority = 1)
	public void dp_PaymentSettings() throws IOException{
		
		//String fmcID = "Pa-05769-1002";
		PaymentPage psPage = PageFactory.initElements(driver, PaymentPage.class);
		psPage.clickNav(driver);
		psPage.selectLabel(driver);
		System.out.println("Label printed successful");
		psPage.selectDropdownValue(driver);
		cs.captureScreenshot(driver);
		System.out.println("Screenshot is captured successfully");
	}
}


