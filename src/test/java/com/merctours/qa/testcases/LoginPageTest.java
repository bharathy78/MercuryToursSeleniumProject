package com.merctours.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.apache.log4j.Logger;
import com.merctours.qa.base.TestBase;
import com.merctours.qa.pages.FlightSearchPage;
import com.merctours.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage signinpage;
	FlightSearchPage flsearch;
	Logger log = Logger.getLogger(LoginPageTest.class);
	
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
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** Mercury Tours Login Page title Test *****************************************");
		String title = signinpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Sign-on: Mercury Tours");
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** Mercury Tours Login Page title Test *****************************************");
	}
	
	@Test(priority=2)
	public void loginTest() {
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** Mercury Tours Login Test *****************************************");
		flsearch = signinpage.signin(prop.getProperty("username"), prop.getProperty("password"));
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** Mercury Tours Login Test *****************************************");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("****************************** Browser is closed *****************************************");
	}
	
}