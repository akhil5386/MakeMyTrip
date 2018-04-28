package com.qa.makemytrip.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.makemytrip.login.Login;
import com.qa.makemytrip.utility.CaptureScreenshot;
import com.qa.makemytrip.utility.OR;
import com.qa.makemytrip.utility.ReadCredentials;
import com.qa.makemytrip.utility.mail;

import jxl.read.biff.BiffException;


public class Base1 {
	WebDriver driver;
	CaptureScreenshot objCaptureScreenshot;
	Login objLogin;
	OR OR;
	mail objmail;
	ReadCredentials objReadCredentials;
	@SuppressWarnings("rawtypes")
	HashMap hm;
	String  testCase;
	
	@BeforeSuite
	public void setUp() throws IOException, BiffException {
		System.setOut(new PrintStream(new FileOutputStream("Report//OutputReport.txt")));
		FileUtils.deleteDirectory(new File("Output/Screenshots"));
		OR = new OR();
		objReadCredentials = new ReadCredentials();
		hm = objReadCredentials.hm;
		testCase = System.getProperty("TestCase");
	}
	
	@BeforeTest
	public void setUP(){
		
		switch(OR.BROWSER) {
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", OR.GECKO);
			driver = new FirefoxDriver();
			System.out.print("Suite is running on Firefox");
			break;
			
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", OR.CHROMEDRIVER);
			driver = new ChromeDriver();
			System.out.print("Suite is running on Chrome");
			break;
			
		case "IE":
			System.setProperty("webdriver.ie.driver", OR.CHROMEDRIVER);
			driver = new FirefoxDriver();
			System.out.print("Suite is running on Internet Explorer");
			break;
		}
		
		
		
		
	}
	
	@BeforeClass
	public void initObj() throws FileNotFoundException, IOException {
		objCaptureScreenshot = new CaptureScreenshot(driver);
	}
	
	
	
	@Test(priority=1)
	public void launchUrl() {
		/*if(hm.containsKey("Launch Url") && hm.get("Launch Url").equals("Yes")){
			driver.get(OR.URL);
		}
		else {
			throw new SkipException("Tese Case is Skipped");
		}*/
		if(testCase.contains("Launch Url")) {
			driver.get(OR.URL);
		}
	}
	
	
	
	@Test(priority=2)
	public void testLogin() throws IOException {
		/*if(hm.containsKey("Login") && hm.get("Login").equals("Yes")){
			objLogin = new Login(driver);
			objLogin.baseLogin(objReadCredentials.username,objReadCredentials.password);
			objLogin=null;
		}
		else {
			throw new SkipException("Tese Case is Skipped");
		}*/
		
		if(testCase.contains("Login")) {
			objLogin = new Login(driver);
			objLogin.baseLogin(objReadCredentials.username,objReadCredentials.password);
			objLogin=null;

		}
	}
	
	@Test(priority=3)
	public void testLogout() {
		if(hm.containsKey("Logout") && hm.get("Logout").equals("Yes")){
			System.out.println("Logout method is passed");
		}
		else {
			throw new SkipException("Tese Case is Skipped");
		}
	}
	
	@SuppressWarnings("static-access")
	@AfterMethod
	public void screenShots(ITestResult mResult) throws IOException {
		if(mResult.FAILURE==mResult.getStatus()) {
			objCaptureScreenshot.takeScreensot(driver,mResult);
		}
			System.gc();
	}
	
	@AfterSuite
	public void tearDown() throws IOException, AddressException, MessagingException {
		objmail= new mail();
		objmail.sendEmail();
		driver.quit();
			
	}
}
