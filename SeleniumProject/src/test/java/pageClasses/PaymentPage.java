package pageClasses;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PaymentPage {

	
	@FindBy(css = "div.col-md-2.label")
	public List<WebElement> label;
	
	@FindBy(css = "div.payments > div.leaseFinanaceDiv.col-md-8 > div.col-md-12.lease > div:nth-child(2)")
	public List <WebElement> dropdown;
	
	@FindBy(css= "#dealNav > ul > li")
	public List<WebElement> liList;
	
	public void clickNav(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		for(WebElement li : liList){
			String liText = li.getText();
			if(liText.equalsIgnoreCase("Payment Settings Administrations")){
				li.click();
			}
		}
	}
	
	public void selectLabel(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		for(WebElement lb : label){
			if(lb.getText().equalsIgnoreCase("LEASE")){
				System.out.println("label name is: " + lb.getText());
			
			}
			
			}
		}
	
	public void selectDropdownValue(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		for(WebElement dp : dropdown){
			dp.click();
			Select select = new Select(dp.findElement(By.cssSelector("#select_value_label_28 > span.md-select-icon")));
			List<WebElement> options = select.getOptions();
			boolean optionExists = false;
			for(WebElement e : options){
				if(e.getText().equalsIgnoreCase("36")){
					optionExists = true;
					break;
				}
				
			}
			Assert.assertTrue(optionExists, "Option 36 exists");
		
			
		}
		
		//System.out.println("dropdown selected");

		//Select select = new Select(dropdown);
				//select.selectByValue("36");
	}
		
}

