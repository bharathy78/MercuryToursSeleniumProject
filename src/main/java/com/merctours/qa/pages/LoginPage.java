package com.merctours.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.merctours.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(name="userName")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="login")
	WebElement submitbtn;
	
	@FindBy(xpath="//a[contains(text(),'REGISTER')]")
	WebElement lnkregister;
	
	// Constructor - Initializing the page objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);		
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();		
	}
	
	public FlightSearchPage signin(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		submitbtn.click();		
		return new FlightSearchPage();
	}	

}