package org.test.DataDrivenFramework;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FaceBook  extends Base{
public static void main(String[] args) throws IOException {
	initializeDriver("http://www.facebook.com");
	WebDriver driver = getDriver();
	
	File openExcel = openExcel("C:\\Users\\Greens-12\\pradeepa\\DataDrivenFramework\\Excel\\FB.xlsx");
	initializeExcelData(openExcel, "Sheet1");
	
	WebElement weUserName = findElementById(driver, "email");
	weUserName.sendKeys(getData(0,"name"));
	
	WebElement wePassword = findElementById(driver, "pass");
	wePassword.sendKeys(getData(0,"pass"));
	
	WebElement LoginId = findElementById(driver, "loginbutton");
	LoginId.click();
	
	WebElement text = findElementByXPath(driver, "(//span[@class = '_50f6'])[2]");
	String text2 = text.getText();
	
	updateExcel(openExcel, "Sheet1", "Login Suggestion", text2);
}
}
