package org.test.DataDrivenFramework;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

public class ExcelUpdation extends Base{
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
	
	WebDriver driver = getDriver("http://www.adactin.com/HotelApp/");
	maximizeWindow(driver);
	
	File excelLocation = openExcel("C:\\Users\\Greens-12\\pradeepa\\DataDrivenFramework\\Excel\\TestData.xlsx");
	
	initializeExcelData(excelLocation, "Sheet1");
	
	String userName = getData(0, "User Name");
	WebElement webElementUserName = findElementById(driver, "username");
	webElementUserName.sendKeys(userName);
	
	String password = getData(0, "Password");
	WebElement webElementPassword = findElementById(driver, "password");
	webElementPassword.sendKeys(password);
	
	WebElement webElementLogin = findElementById(driver, "login");
	webElementLogin.click();
	
	String location = getData(0, "Location");
	WebElement we = null;
	if(location.equals("Melbourne"))
	{
		we = findElementById(driver, "location");
		selectByValue(we,location);
	}
	
	String hotel = getData(0, "Hotels");
	if(hotel.equals("Hotel Sunshine"))
	{
		we = findElementById(driver, "hotels");
		selectByValue(we,hotel);
	}
	
	String roomType = getData(0, "Room Type");
	if(roomType.equals("Double"))
	{
		we = findElementById(driver, "room_type");
		selectByValue(we,roomType);
	}
	
	String numberOfRooms = getData(0, "Number of Rooms");
	if(numberOfRooms.equals("2"))
	{
		we = findElementById(driver, "room_nos");
		selectByValue(we,numberOfRooms);
	}
	String CheckInDate = getData(0, "Check In Date");
	WebElement webElementCheckInDate = findElementById(driver, "datepick_in");
	webElementCheckInDate.sendKeys(CheckInDate);
	
	String CheckOutDate = getData(0, "Check Out Date");
	WebElement webElementCheckOutDate = findElementById(driver, "datepick_out");
	webElementCheckInDate.sendKeys(CheckOutDate);
	
	String adultsPerRoom = getData(0, "Adults per Room");
	if(adultsPerRoom.equals("2"))
	{
		we = findElementById(driver, "adult_room");
		selectByValue(we,adultsPerRoom);
	}
	
	
	String childrenPerRoom = getData(0, "Children per Room");
	if(childrenPerRoom.equals("2"))
	{
		we = findElementById(driver, "child_room");
		selectByValue(we,childrenPerRoom);
	}
	
	WebElement webElementSearch = findElementById(driver, "Submit");
	webElementSearch.click();
	
	WebElement webElementSelect = findElementById(driver, "radiobutton_0");
	webElementSelect.click();
	
	WebElement webElementContinue = findElementById(driver, "continue");
	webElementContinue.click();
	
	String firstName = getData(0, "First Name");
	WebElement webElementFirstName = findElementById(driver, "first_name");
	webElementFirstName.sendKeys(firstName);
	
	String lastName = getData(0, "Last Name");
	WebElement webElementLastName = findElementById(driver, "last_name");
	webElementLastName.sendKeys(lastName);
	
	String billingAddress = getData(0, "Billing Address");
	WebElement webElementbillingAddress = findElementById(driver, "address");
	webElementbillingAddress.sendKeys(billingAddress);
	
	String creditCardNo = getData(0, "Credit Card No");
	WebElement webElementCreditCardNo = findElementById(driver, "cc_num");
	webElementCreditCardNo.sendKeys(creditCardNo);
	
	String creditCardType = getData(0, "Credit Card Type");
	if(creditCardType.equals("MAST"))
	{
		we = findElementById(driver, "cc_type");
		selectByValue(we,creditCardType);
	}
	
	String creditCardExpiryMonth = getData(0, "Expiry Month");
	if(creditCardExpiryMonth.equals("8"))
	{
		we = findElementById(driver, "cc_exp_month");
		selectByValue(we,creditCardExpiryMonth);
	}
	
	
	String creditCardExpiryYear = getData(0, "Expiry Year");
	if(creditCardExpiryYear.equals("2022"))
	{
		we = findElementById(driver, "cc_exp_year");
		selectByValue(we,creditCardExpiryYear);
	}
	
	String creditCardCvvNo = getData(0, "CVV");
	WebElement webElementCreditCardCvvNo = findElementById(driver, "cc_cvv");
	webElementCreditCardCvvNo.sendKeys(creditCardCvvNo);


	WebElement webElementBookNow = findElementById(driver, "book_now");
	webElementBookNow.click();
	
	Thread.sleep(10000);
	
	
	we = findElementById(driver, "order_no");
	String attribute = we.getAttribute("value");
	
	updateExcel(excelLocation, "Sheet1", "Order Number", attribute);

	System.out.println("Updated");

	
	
	}

}
