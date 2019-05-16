package com.merctours.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.merctours.qa.base.TestBase;

public class FlightSelectionPage extends TestBase {
	
	//Page Factory - OR:
	@FindBy(css ="input[name='outFlight']")
	public WebElement outflight;
	
	@FindBy(css ="input[name='inFlight']")
	public WebElement inflight;
	
	@FindBy(xpath ="//input[@name='reserveFlights']")
	public WebElement reserveflights;	
	
	// Constructor - Initializing the page objects:
	public FlightSelectionPage(){
		PageFactory.initElements(driver, this);		
	}
	
	//Actions:
	public String validateFlightSelPageTitle() {
		return driver.getTitle();		
	}
	
	public FlightBookingPage reserveflights() {		
		reserveflights.click();
		return new FlightBookingPage();
	}
	
	//Select a Flight: Mercury Tours
	
	
}
