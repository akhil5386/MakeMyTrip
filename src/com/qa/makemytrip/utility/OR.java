package com.qa.makemytrip.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class OR {
	public String GECKO;
	public String CHROMEDRIVER;
	public String BROWSER;
	public String URL;
	
	public By LOGIN;
	public By USER;
	public By PASSWORD;
	public By LOGIN_BUTTON;
	
	
	
	public OR() throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream("InputFiles//details.properties"));
		GECKO = prop.getProperty("GECKO");
		CHROMEDRIVER = prop.getProperty("CHROMEDRIVER");
		BROWSER = prop.getProperty("BROWSER");
		URL = prop.getProperty("URL");
		LOGIN = By.xpath(prop.getProperty("LOGIN"));
		USER = By.xpath(prop.getProperty("USER"));
		PASSWORD = By.xpath(prop.getProperty("PASSWORD"));
		LOGIN_BUTTON = By.xpath(prop.getProperty("LOGIN_BUTTON"));
	}
}
