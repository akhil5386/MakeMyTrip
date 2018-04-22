package com.qa.makemytrip.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class CaptureScreenshot {

	WebDriver driver;

	public CaptureScreenshot(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public void takeScreensot(WebDriver driver,ITestResult sResult) throws IOException {
		String screenShotName = sResult.getName();
		File screenshot = new File("Output/Screenshots/"+screenShotName+".jpeg");
		File tmpScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(tmpScreenshot, screenshot);

	}
}
