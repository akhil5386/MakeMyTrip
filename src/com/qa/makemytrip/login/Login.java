package com.qa.makemytrip.login;

import java.io.IOException;
import org.openqa.selenium.WebDriver;

import com.qa.makemytrip.utility.ActionKeywords;
import com.qa.makemytrip.utility.OR;
public class Login{
	
	ActionKeywords MMT;
	
	WebDriver driver;
	OR OR;

	
	public Login(WebDriver driver) throws IOException {
		this.driver = driver;
		OR = new OR();
		MMT = new ActionKeywords(driver);
	}
	
	
	public void clickLogin() {
		MMT.click(OR.LOGIN);
	}
	
	public void sendUser(String userName) {
		MMT.text(OR.USER, userName);
	}
	
	public void sendPassword(String password) {
		MMT.text(OR.PASSWORD, password);
	}
	
	public void clickLoginButton() {
		MMT.click(OR.LOGIN_BUTTON);
	}
	
	
	
	public void baseLogin(String userName, String password) {
		this.clickLogin();
		this.sendUser(userName);
		this.sendPassword(password);
		this.clickLoginButton();
	}

}
