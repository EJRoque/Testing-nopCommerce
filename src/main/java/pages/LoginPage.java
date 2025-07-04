package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Log;

public class LoginPage {
	private WebDriver driver;
	
	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	WebElement loginPageLink;
	
	@FindBy(id = "Email")
	WebElement emailTextBox;
	
	@FindBy(id = "Password")
	WebElement passwordTextBox;
	
	@FindBy(className = "password-eye")
	WebElement showPasswordBtn;
	
	@FindBy(id = "RememberMe")
	WebElement rememberMeCheckBox;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div[2]/form/div[2]/div[3]/span/a")
	WebElement forgotPasswordLink;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")
	WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickLoginPage() {
		Log.info("Clicking Login page link...");
		loginPageLink.click();
	}
	
	public void enterEmail(String email) {
		Log.info("Entering email address");
		emailTextBox.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		Log.info("Entering password");
		passwordTextBox.sendKeys(password);
	}
	
	public void clickShowPassword() {
		Log.info("Clicking show password");
		showPasswordBtn.click();
	}
	
	public void clickLoginBtn() {
		Log.info("Clicking Log in button");
		loginBtn.click();
	}
}
