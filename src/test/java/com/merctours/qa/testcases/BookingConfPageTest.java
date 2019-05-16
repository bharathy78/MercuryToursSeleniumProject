package com.merctours.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.merctours.qa.base.TestBase;
import com.merctours.qa.pages.BookingConfPage;
import com.merctours.qa.pages.FlightBookingPage;
import com.merctours.qa.pages.FlightSearchPage;
import com.merctours.qa.pages.FlightSelectionPage;
import com.merctours.qa.pages.LoginPage;

public class BookingConfPageTest extends TestBase {
	//Flight Confirmation: Mercury Tours
	LoginPage signinpage;
	FlightSearchPage flsearch;
	FlightSelectionPage flselection;
	FlightBookingPage flbkg;
	BookingConfPage bkngconf;
	
	public BookingConfPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		signinpage = new LoginPage();
		flsearch = new FlightSearchPage();
		flselection = new FlightSelectionPage();
		flbkg = new FlightBookingPage();
		bkngconf = new BookingConfPage();
		flsearch = signinpage.signin(prop.getProperty("username"), prop.getProperty("password"));
		flselection = flsearch.searchflights();
		flbkg = flselection.reserveflights();
		bkngconf = flbkg.clickbuyflights();
	}	
	
	@Test(priority=1)
	public void BkgConfPageTitleTest() {
		String sflbkgtitle = bkngconf.validateBkgConfPageTitle();
		Assert.assertEquals(sflbkgtitle, "Flight Confirmation: Mercury Tours"," Booking Confirmation Page title does not match.");
	}
	
	@Test(priority=2)
	public void bkgconfmsg() {
		bkngconf.getconfmsg(bkngconf.Confirmation);
	}
	
	@Test(priority=3)
	public void logout() {
		signinpage = bkngconf.clicklogout();
	}
		
	@AfterMethod
	public void tearDown() {
		//driver.quit();		
	}
	

}
