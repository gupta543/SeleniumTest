package utilities;

//import org.testng.AssertJUnit;


//import java.io.File;
//import java.io.IOException;
//import java.lang.reflect.Method;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
//import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.HashMap;
//import java.net.URL;
//import java.nio.file.Files;
import java.util.concurrent.TimeUnit;
//import java.util.logging.Logger;









//import org.apache.commons.logging.LogFactory;
//import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeMethod;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
//import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest {
	
		protected String browserName = "Chrome";
		protected DesiredCapabilities capabilities = new DesiredCapabilities(browserName,"",Platform.ANY);
		protected WebDriver driver = null;
		//protected String usr_name = "Pa-05769-100";
		//protected String usr_pwd = "testid60";
		protected HashMap<String,String> testData;
		//protected String host = "dealerportal.sc2qa.dealerconnection.com";
		

		
		
		
		
		@BeforeTest
		@Parameters({"usr_name", "usr_pwd"})
		public void beforeTest(@Optional String usr_name, @Optional String usr_pwd) throws MalformedURLException{
			//capabilities.setCapability("url", URL);
			//System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
			capabilities.setCapability("browserName", browserName);
			capabilities.setCapability("user", usr_name);
			capabilities.setCapability("password", usr_pwd);
			//driver = new RemoteWebDriver(new URL("https://" + host + "/#/login"), capabilities);
			
				System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.navigate().to("https://dealerportal.sc2qa.dealerconnection.com/#/login");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			
			
			
			
		}
		
			@BeforeMethod
		    public void beforeMethod(Method method) throws IOException {
		           testData = Data.tcData("src/test/java/data/DP_data.xlsx", method.getName(), 0);
		           System.out.println("Data read from excel successfully");
		           //String testName = testData.
		           //testInfo = reports.createTest(testName);
		    }
			
			/*@AfterMethod
			public void captureStatus(ITestResult result){
				if(result.getStatus()==ITestResult.SUCCESS){
					testInfo.log(Status.PASS, "The test Method named as: " + result.getName() + "is passed");
				}
				else if(result.getStatus()==ITestResult.FAILURE){
					testInfo.log(Status.PASS, "The test Method named as: " + result.getName() + "is failed");
					testInfo.log(Status.FAIL, "Test Failure: " + result.getThrowable());
				}
				else if(result.getStatus()==ITestResult.SKIP){
					testInfo.log(Status.PASS, "The test Method named as: " + result.getName() + "is passed");
				}
			}*/
			
}
