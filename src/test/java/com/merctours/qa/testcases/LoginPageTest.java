package com.merctours.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.merctours.qa.base.TestBase;
import com.merctours.qa.pages.FlightSearchPage;
import com.merctours.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage signinpage;
	FlightSearchPage flsearch;
	
	public LoginPageTest(){
		super();		
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		signinpage = new LoginPage();		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = signinpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Sign-on: Mercury Tours");
	}
	
	@Test(priority=2)
	public void loginTest() {
		flsearch = signinpage.signin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();		
	}
	
}