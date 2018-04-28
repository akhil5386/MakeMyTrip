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

	String testCase;
	
	@BeforeSuite
	public void setUp() throws IOException, BiffException {
		testCase = System.getProperty("TestCase");
		System.out.println(testCase);
	}
	
	@Test(priority=1)
	public void m1() {
		if(testCase.contains("TestCase1")) {
			System.out.println("TestCase1");
		}
	}
	
	
	
	@Test(priority=2)
	public void m2() {
		if(testCase.contains("TestCase2")) {
			System.out.println("TestCase2");
		}
	}
	
	@Test(priority=3)
	public void m3() {
		if(testCase.contains("TestCase3")) {
			System.out.println("TestCase3");
		}
	}
	}
