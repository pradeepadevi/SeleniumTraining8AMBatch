package org.test.DataDrivenFramework;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.openqa.selenium.WebElement;

public class XMLToJava extends Base {

	
	public static void main(String[] args) throws JAXBException {
		XMLToJava obj = new XMLToJava();
		obj.convertXMLToJava();
	}
	public void convertXMLToJava() throws JAXBException {
		// TODO Auto-generated method stub
		JAXBContext context = JAXBContext.newInstance(Demoqa.class);
		
		Unmarshaller un = context.createUnmarshaller();
		
		Demoqa obj = (Demoqa)un.unmarshal(new File("demoqa.xml"));
		
		initializeDriver("http://demoqa.com/registration/");
		//WebDriver driver = getDriver();
		DemoqaRegistrationPage objDemoqaRegistrationPage = new DemoqaRegistrationPage();
		
		String firstname = obj.getFirstname();
		WebElement webElementFirstName = objDemoqaRegistrationPage.getFirstName();
		sendText(webElementFirstName, firstname);

		
		String lastname = obj.getLastname();
		WebElement webElementLasttName = objDemoqaRegistrationPage.getLastName();
		sendText(webElementLasttName, lastname);
		
		
		String maritalstatus = obj.getMaritalstatus();
		WebElement webElementMaritalStatus;
		if(maritalstatus.equals("Single"))
		{
			webElementMaritalStatus = objDemoqaRegistrationPage.getMaritalStatusSingle();
			webElementMaritalStatus.click();
		}
		
		String hobby = obj.getHobby();
		WebElement webElementHobby;
		if(hobby.equals("Cricket"))
		{
			webElementHobby = objDemoqaRegistrationPage.getHobbyCricket();
			webElementHobby.click();
		}
		

		String country = obj.getCountry();
		WebElement webElementCountry = objDemoqaRegistrationPage.getCountry();
		sendText(webElementCountry, country);
		
	    String phone = obj.getPhonenumber();
		WebElement webElementphonenumber = objDemoqaRegistrationPage.getPhone();
		sendText(webElementphonenumber, phone);
		
		String date = obj.getDate();
		WebElement webElementDate = objDemoqaRegistrationPage.getDate();
		sendText(webElementDate, date);
		
		String month = obj.getMonth();
		WebElement webElementMonth = objDemoqaRegistrationPage.getMonth();
		sendText(webElementMonth, month);
		
		String year = obj.getYear();
		WebElement webElementYear = objDemoqaRegistrationPage.getYear();
		sendText(webElementYear, year);
		
		String username = obj.getUsername();
		WebElement webElementUserName = objDemoqaRegistrationPage.getUserName();
		sendText(webElementUserName, username);
		
		
		String email = obj.getEmail();
		WebElement webElementEmail = objDemoqaRegistrationPage.getEmail();
		sendText(webElementEmail, email);
		
		String aboutyourself = obj.getAboutyourself();
		WebElement webElementAboutYourself = objDemoqaRegistrationPage.getDescription();
		sendText(webElementAboutYourself, aboutyourself);
		
		
		String password = obj.getPassword();
		WebElement webElementPassword = objDemoqaRegistrationPage.getPassword();
		sendText(webElementPassword, password);
		
		
		String confirmpassword = obj.getConfirmpassword();
		WebElement webElementConfirmPassword = objDemoqaRegistrationPage.getConfirmPassword();
		sendText(webElementConfirmPassword, confirmpassword);
				
	
		
	}
	
}
