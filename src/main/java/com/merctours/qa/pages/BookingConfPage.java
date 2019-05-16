package com.merctours.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.merctours.qa.base.TestBase;

public class BookingConfPage extends TestBase {
	
	//Page Factory - OR:
	@FindBy(xpath ="//font[@size='+1']")
	public WebElement Confirmation;
		
	@FindBy(xpath ="//img[@src='/images/forms/Logout.gif']")
	public WebElement logout;
		
	// Constructor - Initializing the page objects:
	public BookingConfPage(){
		PageFactory.initElements(driver, this);	
	}
	
	//Actions:
	public String validateBkgConfPageTitle() {
		return driver.getTitle();		
	}
	
	// Verify if the confirmation page is displayed
	public void getconfmsg( WebElement WE) {
		String sconf = Confirmation.getText();
		if(sconf.contains("Your itinerary has been booked!")){
			System.out.println("Flight booking was successful");
		}else{
			System.out.println("Flight booking failed");
		}
	}
	
	public LoginPage clicklogout() {
		logout.click();
		return new LoginPage();
	}	

}
