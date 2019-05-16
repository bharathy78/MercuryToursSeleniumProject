package com.merctours.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.merctours.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 40;
	public static long IMPLICIT_WAIT = 30;
	
	public static String TESTDATA_SHEET_PATH = "F:\\WD SmartWare.swstor\\ANIRUDH-PC\\Project\\Workspace\\MercToursTests\\src\\main\\java\\com\\merctours\\qa\\testdata\\MercToursTestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	public static String selval;
	
	
	public static Object[][] getTestData(String sheetName){
		FileInputStream fip  = null;
		try {
			fip = new FileInputStream(TESTDATA_SHEET_PATH);			
		} catch (FileNotFoundException e) {
			e.printStackTrace();			
		}
		try {
			book = WorkbookFactory.create(fip);			
		}catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "\\screenshots\\" + System.currentTimeMillis() + ".png"));
	}		

	public static void fn_selectfrmlstbyval(WebElement we) throws InterruptedException, NullPointerException {
		try {
			Thread.sleep(2000);
			Select selObj=new Select(we);
			List <WebElement>dropdown = selObj.getOptions();
			for(int i=0;i<dropdown.size();i++){
				@SuppressWarnings("unused")
				String drop_down_values=dropdown.get(i).getText();
				//System.out.println("The values selected in the drop down is: "+drop_down_values);
			}
			Random rand = new Random();
			WebElement seloption = dropdown.get(rand.nextInt(dropdown.size()));
			selval = seloption.getAttribute("value");
			selObj.selectByValue(selval);
			System.out.println("Item Selected is:"+selval);			
		}catch (Exception e) {
			e.printStackTrace();			
		 }
	}

	public static void fn_Clickradiobutton(List<WebElement> we) throws InterruptedException {
		Random rnd = new Random();
		List<WebElement> radios = driver.findElements((By) we);
		int size = radios.size();
		for (int i=0; i< size; i++) {
			String sValue = radios.get(i).getAttribute("value");
			System.out.println("Radio button Name "+sValue);
			radios.get(rnd.nextInt(radios.size())).click();	        	
		}
	}	

}