package utilities;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportManager {
	public static ExtentReports reports;
	
	public static ExtentReports invokeExtentReport(){
		reports = new ExtentReports("D:\\Git\\SeleniumProject\\AutomationReport.html");
		return reports;
	}
}
