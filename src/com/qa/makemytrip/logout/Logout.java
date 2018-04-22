package com.qa.makemytrip.logout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Logout {
	
	WebDriver driver;
	
	//By LOGOUT = By.xpath("");
	
	@FindBy (xpath = "")
	WebElement USERNAME;
	
	@FindBy (xpath = "")
	WebElement PASSWORD;
	
	public Logout(WebDriver driver) {
		this.driver = driver;
		USERNAME.sendKeys("");
		USERNAME.click();
	}
	
	public void clickLogout() {
		//driver.findElement(LOGOUT).click();
	}
	

}
