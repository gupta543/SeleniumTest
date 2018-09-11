package pageClasses;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DealerPortalPage {
	
	public WebElement fmcIDElement;
	public List<WebElement> fmcIDList;
	public List<WebElement> ulList;
	String liText;
	String temp;
	
	//public WebElement pencilIcon;
	public List<WebElement> pencilList;
	
	public void clickPencilIcon(WebDriver driver){
		//WebDriverWait wait = new WebDriverWait(driver, 100);
		driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		ulList = driver.findElements(By.cssSelector("#userDeatail > div:nth-child(2) > div > div.delrCntwrpr > ul"));
		for(WebElement ul : ulList){
			//System.out.println(ul.getText());
			//System.out.println(ul.getSize());
			fmcIDList = ul.findElements(By.cssSelector("#userDeatail > div:nth-child(2) > div > div.delrCntwrpr > ul > li:nth-child(6)"));
			pencilList = ul.findElements(By.cssSelector("#userDeatail > div:nth-child(2) > div > div.delrCntwrpr > ul > li:nth-child(8)"));
			for(WebElement pl: pencilList){
				for(WebElement li: fmcIDList){
					liText = li.getText();
					if(liText.equalsIgnoreCase("Pa-05769-1002")){
						System.out.println(liText);
						pl.click();
					}
				}
			}
		}
		
	}
}
		
	

