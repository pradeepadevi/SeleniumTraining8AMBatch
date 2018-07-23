package org.test.DataDrivenFramework;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class JUnitSample extends Base {

	static WebDriver driver;
	@BeforeClass
	public static void launchBrowser()
	{
		initializeDriver("http://demoqa.com/registration/");
		driver = getDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void Test1() throws IOException
	{
		File excelLocation = openExcel("C:\\Users\\Greens-12\\pradeepa\\DataDrivenFramework\\Excel\\DemoqaRegistrationDetails.xlsx");
		initializeExcelData(excelLocation, "Sheet1");
		DemoqaRegistrationPage demoqaPage = new DemoqaRegistrationPage();
		
		sendText(demoqaPage.getFirstName(), getData(2,"First Name"));
		
		Assert.assertEquals("Praveen", demoqaPage.getFirstName().getAttribute("value"));
		
		sendText(demoqaPage.getLastName(), getData(2,"Last Name"));
	
		Assert.assertEquals("KMani", demoqaPage.getLastName().getAttribute("value"));
		
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
			Assert.assertTrue(demoqaPage.getMaritalStatusDivorced().isSelected());
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
	
	@AfterClass
	public static void quitDriver()
	{
		
		driver.quit();
	}

	@Before
	public void browserLaunchTime()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println(formatter.format(date));
		
	}
	@After
	public void browserExitTime()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println(formatter.format(date));
		
	}
	
	
	
}
