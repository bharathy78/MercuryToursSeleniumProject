package com.merctours.qa.testcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.merctours.qa.base.TestBase;

import com.merctours.qa.pages.LoginPage;
import com.merctours.qa.util.TestUtil;
import com.merctours.qa.pages.FlightSearchPage;
import com.merctours.qa.pages.FlightSelectionPage;
import com.merctours.qa.pages.FlightBookingPage;
import com.merctours.qa.pages.BookingConfPage;

public class FlightBookingPageTest extends TestBase{
	LoginPage signinpage;
	FlightSearchPage flsearch;
	FlightSelectionPage flselection;
	FlightBookingPage flbkg;
	BookingConfPage bkngconf;
	
	String sheetName = "FlightBooking";
	
	public FlightBookingPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		signinpage = new LoginPage();
		flsearch = new FlightSearchPage();
		flselection = new FlightSelectionPage();
		flbkg = new FlightBookingPage();
		flsearch = signinpage.signin(prop.getProperty("username"), prop.getProperty("password"));
		flselection = flsearch.searchflights();
		flbkg = flselection.reserveflights();	
	}	
	
	@Test(priority=1)
	public void FlightBkgPageTitleTest() {
		String sflbkgtitle = flbkg.validateFlightBkgPageTitle();
		Assert.assertEquals(sflbkgtitle, "Book a Flight: Mercury Tours","Flight Booking Page title does not match.");
	}
	
	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;		
	}
	
	@Test(priority=2, dataProvider = "getTestData")
	public void setpassdetails(String firstname, String lastname, String ccnumber) {
		for(WebElement fname: flbkg.fName){
			fname.sendKeys(firstname);
		}		
		for(WebElement lname: flbkg.lName){
			lname.sendKeys(lastname);
		}		
		flbkg.ccnum.sendKeys(ccnumber);		
		flbkg.clickbuyflights();
	}	
		
	@AfterMethod
	public void tearDown() {
		//driver.quit();		
	}
}