package org.test.DataDrivenFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoqaRegistrationPage extends Base {

	
	public DemoqaRegistrationPage() {
		// TODO Auto-generated constructor stub
		WebDriver driver = getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="name_3_firstname")
	private WebElement firstName;
	
	@FindBy(id="name_3_lastname")
	private WebElement lastName;
	
	@FindBy(id="dropdown_7")
	private WebElement country;
	
	@FindBy(id="phone_9")
	private WebElement phone;
	
	@FindBy(id="username")
	private WebElement userName;
	
	@FindBy(id="email_1")
	private WebElement email;
	
	@FindBy(id="description")
	private WebElement description;
	
	@FindBy(id="password_2")
	private WebElement password;
	
	@FindBy(id="confirm_password_password_2")
	private WebElement confirmPassword;
	
	@FindBy(id="mm_date_8")
	private WebElement date;
	
	@FindBy(id="dd_date_8")
	private WebElement month;
	
	@FindBy(id="yy_date_8")
	private WebElement year;
	
	
	
	@FindBy(xpath="//input[@value='single']")
	private WebElement maritalStatusSingle;
	
	
	@FindBy(xpath="//input[@value='married']")
	private WebElement maritalStatusMarried;
	
	
	@FindBy(xpath="//input[@value='divorced']")
	private WebElement maritalStatusDivorced;
	
	
	
	@FindBy(xpath="//input[@value='dance']")
	private WebElement hobbyDance;
	
	
	@FindBy(xpath="//input[@value='reading']")
	private WebElement hobbyReading;

	@FindBy(xpath="//input[@value='cricket ']")
	private WebElement hobbyCricket;
	

	
	public WebElement getMaritalStatusSingle() {
		return maritalStatusSingle;
	}

	public WebElement getMaritalStatusMarried() {
		return maritalStatusMarried;
	}

	public WebElement getMaritalStatusDivorced() {
		return maritalStatusDivorced;
	}

	public WebElement getHobbyDance() {
		return hobbyDance;
	}

	public WebElement getHobbyReading() {
		return hobbyReading;
	}

	public WebElement getHobbyCricket() {
		return hobbyCricket;
	}

	public WebElement getFirstName() {
		return firstName;
	}
	
	public WebElement getLastName() {
		return lastName;
	}
		
	public WebElement getCountry() {
		return country;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getDescription() {
		return description;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getConfirmPassword() {
		return confirmPassword;
	}

	public WebElement getDate() {
		return date;
	}

	public void setDate(WebElement date) {
		this.date = date;
	}

	public WebElement getMonth() {
		return month;
	}

	public void setMonth(WebElement month) {
		this.month = month;
	}

	public WebElement getYear() {
		return year;
	}

	public void setYear(WebElement year) {
		this.year = year;
	}
	
}
