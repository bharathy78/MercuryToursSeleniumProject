package com.merctours.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.merctours.qa.base.TestBase;

public class FlightBookingPage extends TestBase {
	
	//Page Factory - OR:
	@FindBy(xpath = "//input[contains(@name,'passFirst')]")
	@CacheLookup
	public List<WebElement> fName;
	
	@FindBy(xpath = "//input[contains(@name,'passLast')]")
	@CacheLookup
	public List<WebElement> lName;
	
	@FindBy(name = "creditnumber")
	@CacheLookup
	public WebElement ccnum;
	
	@FindBy(xpath = "//input[@name='buyFlights']")
	public WebElement confirmbooking; 
	
	// Constructor - Initializing the page objects:
	public FlightBookingPage(){
		PageFactory.initElements(driver, this);		
	}
	
	//Actions:
	public String validateFlightBkgPageTitle() {
		return driver.getTitle();		
	}
	
//	public void sendfname(List<WebElement> WE) {
//		for(WebElement fname: fName){
//			fname.sendKeys("TestFirst");
//		}
//   	}
//		
//	public void sendlname(List<WebElement> WE) {
//		for(WebElement lname: lName){
//			lname.sendKeys("TestLast");
//		}
//	}
//	   
//	public void sendccnumber() {
//		ccnum.sendKeys("2345 6734 5645 3456");   
//	}
	   
	public BookingConfPage clickbuyflights() {
		confirmbooking.click();
		return new BookingConfPage();
	}
}