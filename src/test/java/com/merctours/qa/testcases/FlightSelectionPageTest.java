package com.merctours.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.merctours.qa.base.TestBase;
import com.merctours.qa.pages.FlightBookingPage;
import com.merctours.qa.pages.FlightSearchPage;
import com.merctours.qa.pages.FlightSelectionPage;
import com.merctours.qa.pages.LoginPage;

public class FlightSelectionPageTest extends TestBase{
	LoginPage signinpage;
	FlightSearchPage flsearch;
	FlightSelectionPage flselection;
	FlightBookingPage flbkg;
	
	public FlightSelectionPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		signinpage = new LoginPage();
		flsearch = new FlightSearchPage();
		flselection = new FlightSelectionPage();
		flsearch = signinpage.signin(prop.getProperty("username"), prop.getProperty("password"));
		flselection = flsearch.searchflights();
	}
	
	@Test(priority=1)
	public void FlightSelectionPageTitleTest() {
		String sflseltitle = flselection.validateFlightSelPageTitle();
		Assert.assertEquals(sflseltitle, "Select a Flight: Mercury Tours","Flight Selection Search Page title does not match.");
	}
	
	@Test(priority=2)
	public void flightseltest() {
		flbkg = flselection.reserveflights();
	}
		
	@AfterMethod
	public void tearDown() {
		//driver.quit();		
	}
}