package com.merctours.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.merctours.qa.base.TestBase;
import com.merctours.qa.pages.FlightSearchPage;
import com.merctours.qa.pages.FlightSelectionPage;
import com.merctours.qa.pages.LoginPage;

public class FlightSearchPageTest extends TestBase{
	LoginPage signinpage;
	FlightSearchPage flsearch;
	FlightSelectionPage flselection;
	
	public FlightSearchPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		signinpage = new LoginPage();
		flsearch = signinpage.signin(prop.getProperty("username"), prop.getProperty("password"));			
	}
	
	@Test(priority=1)
	public void FlightSearchPageTitleTest() {
		String sflsearchtitle = flsearch.validateFlightSearchPageTitle();
		Assert.assertEquals(sflsearchtitle, "Find a Flight: Mercury Tours:","Flight Search Page title does not match.");
	}
	
	@Test(priority=2)
	public void searchflighttest() throws Exception {
		flselection = flsearch.searchflights();
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();		
	}
}
