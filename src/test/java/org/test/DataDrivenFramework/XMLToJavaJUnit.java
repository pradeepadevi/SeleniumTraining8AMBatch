package org.test.DataDrivenFramework;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class XMLToJavaJUnit extends Base {

	static WebDriver driver;
	static Demoqa obj;
	static DemoqaRegistrationPage objDemoqaRegistrationPage;
	@BeforeClass
	public static void launchBrowser() throws JAXBException
	{
		initializeDriver("http://demoqa.com/registration/");
		driver = getDriver();
		driver.manage().window().maximize();
        JAXBContext context = JAXBContext.newInstance(Demoqa.class);
		
		Unmarshaller un = context.createUnmarshaller();
		
		obj = (Demoqa)un.unmarshal(new File("demoqa.xml"));
        objDemoqaRegistrationPage = new DemoqaRegistrationPage();
	}
	@Test
	public void testFirstName()
	{
		String firstname = obj.getFirstname();
		WebElement webElementFirstName = objDemoqaRegistrationPage.getFirstName();
		sendText(webElementFirstName, firstname);
		Assert.assertEquals("Nisha", webElementFirstName.getAttribute("value"));
	}
	@Test
	public void testLastName(){
		// TODO Auto-generated method stub       
		String lastname = obj.getLastname();
		WebElement webElementLasttName = objDemoqaRegistrationPage.getLastName();
		sendText(webElementLasttName, lastname);
		Assert.assertEquals("Renga", webElementLasttName.getAttribute("value"));
	}
	@Test
	public void testMaritalStatus() {
		// TODO Auto-generated method stub

	
		String maritalstatus = obj.getMaritalstatus();
		WebElement webElementMaritalStatus;
		if(maritalstatus.equals("Single"))
		{
			webElementMaritalStatus = objDemoqaRegistrationPage.getMaritalStatusSingle();
			webElementMaritalStatus.click();
			Assert.assertTrue(webElementMaritalStatus.isSelected());
		}
		
	}

	@Test
	public void testHobby() {
		String hobby = obj.getHobby();
		WebElement webElementHobby;
		if(hobby.equals("Cricket"))
		{
			webElementHobby = objDemoqaRegistrationPage.getHobbyCricket();
			webElementHobby.click();
			Assert.assertTrue(webElementHobby.isSelected());
		}
		
	}
	
	@Test
	public void testCountry() {
		String country = obj.getCountry();
		WebElement webElementCountry = objDemoqaRegistrationPage.getCountry();
		sendText(webElementCountry, country);
		Assert.assertEquals("India", webElementCountry.getAttribute("value"));
	}
	
	@Test
	public void testPhoneNumber() {
	    String phone = obj.getPhonenumber();
		WebElement webElementphonenumber = objDemoqaRegistrationPage.getPhone();
		sendText(webElementphonenumber, phone);
		Assert.assertEquals("1234567890", webElementphonenumber.getAttribute("value"));
	}
	
	@Test
	public void testDate() {
		String date = obj.getDate();
		WebElement webElementDate = objDemoqaRegistrationPage.getDate();
		sendText(webElementDate, date);
		Assert.assertEquals("2", webElementDate.getAttribute("value"));
	}
	
	@Test
	public void testMonth() {
		String month = obj.getMonth();
		WebElement webElementMonth = objDemoqaRegistrationPage.getMonth();
		sendText(webElementMonth, month);
		Assert.assertEquals("5", webElementMonth.getAttribute("value"));
	}
	@Test
	public void testYear() {	
		String year = obj.getYear();
		WebElement webElementYear = objDemoqaRegistrationPage.getYear();
		sendText(webElementYear, year);
		Assert.assertEquals("1997", webElementYear.getAttribute("value"));
	}
	@Test
	public void testUserName() {
		String username = obj.getUsername();
		WebElement webElementUserName = objDemoqaRegistrationPage.getUserName();
		sendText(webElementUserName, username);
		Assert.assertEquals("nisha", webElementUserName.getAttribute("value"));
	}
		
	@Test
	public void testEmail() {	
		String email = obj.getEmail();
		WebElement webElementEmail = objDemoqaRegistrationPage.getEmail();
		sendText(webElementEmail, email);
		Assert.assertEquals("nisha@gmail.com", webElementEmail.getAttribute("value"));
	}
	
	@Test
	public void testAboutYourself() {
		String aboutyourself = obj.getAboutyourself();
		WebElement webElementAboutYourself = objDemoqaRegistrationPage.getDescription();
		sendText(webElementAboutYourself, aboutyourself);
		Assert.assertEquals("My name is Nisha", webElementAboutYourself.getAttribute("value"));
	}
		
	@Test
	public void testPassword() {	
		String password = obj.getPassword();
		WebElement webElementPassword = objDemoqaRegistrationPage.getPassword();
		sendText(webElementPassword, password);
		Assert.assertEquals("asdf", webElementPassword.getAttribute("value"));
	}
	
	@Test
	public void testConfirmPassword() {
		String confirmpassword = obj.getConfirmpassword();
		WebElement webElementConfirmPassword = objDemoqaRegistrationPage.getConfirmPassword();
		sendText(webElementConfirmPassword, confirmpassword);
		Assert.assertEquals("asdf", webElementConfirmPassword.getAttribute("value"));
				
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

