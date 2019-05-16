package com.merctours.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.merctours.qa.base.TestBase;
import com.merctours.qa.util.TestUtil;

public class FlightSearchPage extends TestBase {
	
	//Page Factory - OR:
	@FindBy(name = "tripType")
	public List<WebElement> otriptype;
	
	@FindBy(name="passCount")
	public WebElement passengercount;
	
	@FindBy(id="month")
	public WebElement month_dropdown;
	
	@FindBy(name="fromPort")
	public WebElement fromport; 
	 
	@FindBy(name="fromMonth")
	public WebElement frommonth;
	 
	@FindBy(name="fromDay")
	public WebElement fromday;
	 
	@FindBy(name="toPort")
	public WebElement destport;
	 
	@FindBy(name="toMonth")
	public WebElement retmonth;
	 
	@FindBy(name="toDay")
	public WebElement rtndate;
	 
	@FindBy(name= "servClass")
	public List<WebElement> serviceclass;
	 
	@FindBy(name="airline")
	public WebElement airline;
	 
	@FindBy(name="findFlights")
	public WebElement contbtn;
	
	// Constructor - Initializing the page objects:
	public FlightSearchPage(){
		PageFactory.initElements(driver, this);		
	}
	
	//Actions:
	public String validateFlightSearchPageTitle() {
		return driver.getTitle();		
	}
	
	public FlightSelectionPage searchflights() throws Exception {
		try {
			TestUtil.fn_selectfrmlstbyval(passengercount);
			TestUtil.fn_selectfrmlstbyval(fromport);
			TestUtil.fn_selectfrmlstbyval(frommonth);
			TestUtil.fn_selectfrmlstbyval(fromday);
			TestUtil.fn_selectfrmlstbyval(destport);
			TestUtil.fn_selectfrmlstbyval(retmonth);
			TestUtil.fn_selectfrmlstbyval(rtndate);
			contbtn.click();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new FlightSelectionPage();	
	}
}