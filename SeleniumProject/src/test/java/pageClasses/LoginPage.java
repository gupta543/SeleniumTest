package pageClasses;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
//import org.testng.annotations.Test;



//import utilities.Utilities;


public class LoginPage
{
	
    
    @FindBy(xpath = ".//*[@id='body-content']/main/form/div[1]/div[1]/div[1]/input")
	public WebElement fmcDealerID;
    @FindBy(xpath = ".//*[@id='body-content']/main/form/div[1]/div[1]/div[2]/input")
    public WebElement fmcDealerPassword;
    @FindBy(xpath = ".//*[@id='body-content']/main/form/div[1]/div[2]/div/input")
    public WebElement fmcLoginButton;
   
   public void enterDealerID(String dealerID){
	
		fmcDealerID.sendKeys(dealerID);
	   //return fmcDealerID;
   }
   public void enterDealerPassword(String password){
	   
	   fmcDealerPassword.sendKeys(password);
	   //return fmcDealerPassword;
   }
   public void dpClickLogin(){
	   fmcLoginButton.click();
	 
   }
}


