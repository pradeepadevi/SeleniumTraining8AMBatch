package org.test.DataDrivenFramework;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoqaRegistrationAutomation extends Base {

	public static void main(String[] args) throws IOException {
		initializeDriver("http://demoqa.com/registration/");
		WebDriver driver = getDriver();
		driver.manage().window().maximize();
		
			
		File excelLocation = openExcel("C:\\Users\\Greens-12\\pradeepa\\DataDrivenFramework\\Excel\\DemoqaRegistrationDetails.xlsx");
		initializeExcelData(excelLocation, "Sheet1");
		DemoqaRegistrationPage demoqaPage = new DemoqaRegistrationPage();
		
		sendText(demoqaPage.getFirstName(), getData(2,"First Name"));
		
		sendText(demoqaPage.getLastName(), getData(2,"Last Name"));
				
		
		String maritalStatus = getData(2,"Marital Status");
		if(maritalStatus.equals("Single"))
		{
			demoqaPage.getMaritalStatusSingle().click();

		} 
		else if(maritalStatus.equals("Married"))
		{
			demoqaPage.getMaritalStatusMarried().click();
		} 
		else if(maritalStatus.equals("Divorced"))
		{
			demoqaPage.getMaritalStatusDivorced().click();
		}
		else
		{
			System.out.println("No a proper input");
		}
		
		String hobby = getData(2,"Hobby");
		if(hobby.equals("Dance"))
		{
			demoqaPage.getHobbyDance().click();
		} 
		else if(hobby.equals("Reading"))
		{
			demoqaPage.getHobbyReading().click();
		} 
		else if(hobby.equals("Cricket"))
		{
			demoqaPage.getHobbyCricket().click();
		}
		else
		{
			System.out.println("No a proper input");
		}
		
		sendText(demoqaPage.getCountry(), getData(2,"Country"));
		sendText(demoqaPage.getPhone(), getData(2,"Phone Number"));
		sendText(demoqaPage.getUserName(), getData(2,"Username"));
		sendText(demoqaPage.getEmail(), getData(2,"E-mail"));
		sendText(demoqaPage.getDescription(), getData(2,"About Yourself"));
		sendText(demoqaPage.getPassword(), getData(2,"Password"));
		sendText(demoqaPage.getConfirmPassword(), getData(2,"Confirm Password"));

	}
	 
}
