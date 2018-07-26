package utilities;

import java.net.MalformedURLException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
//import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
		protected String browserName = "Chrome";
		protected DesiredCapabilities capabilities = new DesiredCapabilities(browserName,"",Platform.ANY);
		protected WebDriver driver = null;
		protected String usr_name = "Pa-05769-100";
		protected String usr_pwd = "testid60";
		@BeforeTest
		@Parameters({"usr_name", "usr_pwd"})
		public void beforeTest(@Optional String usr_name, @Optional String usr_pwd) throws MalformedURLException{
			//capabilities.setCapability("url", URL);
			//capabilities.setCapability("browserName", "Chrome");
			//driver = new RemoteWebDriver(new URL("https://dealerportal.sc2qa.dealerconnection.com/#/login"), capabilities);
			System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://dealerportal.sc2qa.dealerconnection.com/#/login");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			capabilities.setCapability("user", usr_name);
			capabilities.setCapability("password", usr_pwd);
		}
}
