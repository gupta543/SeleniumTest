package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class CaptureScreenshot {
	
	public static void captureScreenshot(WebDriver driver) throws IOException{
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("D:/Git/SeleniumProject/Screenshots/" + System.currentTimeMillis() +".jpg"));
	}
}
