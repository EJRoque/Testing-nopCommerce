package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Log;



public class RegisterPage {
	private WebDriver driver;
	
	@FindBy(id="gender-male")
	WebElement genderBtn;
	
	@FindBy(id="FirstName")
	WebElement firstNameTextBox;
	
	@FindBy(id="FirstName-error")
	WebElement firstNameErrorText;
	
	@FindBy(id="LastName")
	WebElement lastNameTextBox;
	
	@FindBy(id="LastName-error")
	WebElement lastNameErrorText;
	
	@FindBy(id="Email")
	WebElement emailTextBox;
	
	@FindBy(id="Email-error")
	WebElement emailErrorText;
	
	@FindBy(id="Company")
	WebElement companyTextBox;
	
	@FindBy(id="Newsletter")
	WebElement newsLetterBtn;
	
	@FindBy(id="Password")
	WebElement passwordTextBox;
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmPasswordTextBox;
	
	@FindBy(id="ConfirmPassword-error")
	WebElement passwordErrorText;
	
	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
	WebElement registerPageLink;
	
	@FindBy(id = "register-button")
	WebElement registerBtn;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickRegisterPage() {
		Log.info("clicking Register page link");
		registerPageLink.click();
	}
	
	public void selectGender() {
		Log.info("Selecting gender...");
		genderBtn.click();
	}
	
	public boolean isMaleGenderSelected() {
	    return genderBtn.isSelected() && genderBtn.getDomAttribute("value").equals("M");
	};
	
	public void enterFirstName(String firstName) {
		firstNameTextBox.sendKeys(firstName);
		Log.info("First name entered...");
	}
	
	public boolean firstNameErrorMessage() {
		return firstNameErrorText.isDisplayed() && firstNameErrorText.getText().contains("First name is required.");
	}
	
	public void enterLastName(String lastName) {
		lastNameTextBox.sendKeys(lastName);
		Log.info("Last name entered...");
	}
	
	public boolean lastNameErrorMessage() {
		return lastNameErrorText.isDisplayed() && lastNameErrorText.getText().contains("Last name is required.");
	}
	
	public void enterEmail(String email) {
		emailTextBox.sendKeys(email);
		Log.info("Email entered...");
	}
	
	public boolean emailIsRequiredErrorMessage() {
		return emailErrorText.isDisplayed() && emailErrorText.getText().contains("Email is required.");
	}
	
	public boolean invalidEmailErrorMessage() {
		return emailErrorText.isDisplayed() && emailErrorText.getText().contains("Please enter a valid email address.");
	}
	
	public void enterCompanyName(String companyName) {
		companyTextBox.sendKeys(companyName);
		Log.info("Company name entered...");
	}
	
	public void clickNewsLetter() {
		Log.info("unclick Newsletter button");
		newsLetterBtn.click();
	}
	
	public void enterPassword(String password) {
		passwordTextBox.sendKeys(password);
		Log.info("Password entered...");
	}
	
	public void enterConfirmPassword(String confirmPassword) {
		confirmPasswordTextBox.sendKeys(confirmPassword);
		Log.info("Confirm password entered...");
	}
	
	public boolean passwordIsRequiredErrorMessage() {
		return passwordErrorText.isDisplayed() && passwordErrorText.getText().contains("Password is required.");
	}
	
	public boolean passwordMismatchErrorMessage() {
		return passwordErrorText.isDisplayed() && passwordErrorText.getText().contains("The password and confirmation password do not match.");
	}
	
	public void clickRegisterBtn() {
		registerBtn.click();
		Log.info("Register button clicked...");
	}
}
