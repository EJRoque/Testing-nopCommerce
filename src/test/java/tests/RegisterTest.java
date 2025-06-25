package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import pages.RegisterPage;
import utils.ExtentReportManager;
import utils.Log;

public class RegisterTest extends BaseTest{
	
	@Test
	public void testSuccessfulRegistration() {
		test = ExtentReportManager.createTest("Test Successful Register");
		RegisterPage registerPage = new RegisterPage(driver);
		
		registerPage.clickRegisterPage();
		
		registerPage.selectGender();
		
		registerPage.enterFirstName("John");
		registerPage.enterLastName("Doe");
		registerPage.enterEmail("john.doe" + System.currentTimeMillis() + "@mail.com");
		registerPage.enterCompanyName("Doe Inc.");
		registerPage.clickNewsLetter();
		registerPage.enterPassword("Test@1234");
		registerPage.enterConfirmPassword("Test@1234");
		registerPage.clickRegisterBtn();
		test.pass("Register Successfully");
	}
	
	@Test
	public void testMismatchedPasswords() {
		test = ExtentReportManager.createTest("Test Mismatched Passwords");
		RegisterPage registerPage = new RegisterPage(driver);
		
		registerPage.clickRegisterPage();
		
		registerPage.selectGender();
		
		registerPage.enterFirstName("Mismatch");
		registerPage.enterLastName("Test");
		registerPage.enterEmail("mismatch" + System.currentTimeMillis() + "@mail.com");
		registerPage.enterCompanyName("Test Inc.");
		registerPage.clickNewsLetter();
		registerPage.enterPassword("Password123");
		registerPage.enterConfirmPassword("WrongPassword");
		registerPage.clickRegisterBtn();
		
		if (registerPage.passwordMismatchErrorMessage()) {
		    test.pass("Password mismatch error appeared as expected.");
		} else {
		    test.fail("❌ Expected password mismatch error was not displayed.");
		    Assert.fail("❌ Expected password mismatch error was not displayed.");
		}

	}
	
	@Test
	public void testInvalidEmailFormat() {
		test = ExtentReportManager.createTest("Test Invalid Email");
		RegisterPage registerPage = new RegisterPage(driver);
		
		registerPage.clickRegisterPage();
		
		registerPage.selectGender();
		
		registerPage.enterFirstName("Invalid");
		registerPage.enterLastName("Email");
		registerPage.enterEmail("invalidemail");
		registerPage.enterCompanyName("Fake Corp");
		registerPage.clickNewsLetter();
		registerPage.enterPassword("Test@1234");
		registerPage.enterConfirmPassword("Test@1234");
		registerPage.clickRegisterBtn();
		
		if (registerPage.invalidEmailErrorMessage()) {
		    test.pass("Invalid email format validation appeared as expected.");
		} else {
		    test.fail("❌ Expected email format error was not displayed.");
		    Assert.fail("❌ Expected email format error was not displayed.");
		}

	}
	
	@Test
	public void testEmptyRequiredFields() {
		test = ExtentReportManager.createTest("Test Empty Required Fields");
		RegisterPage registerPage = new RegisterPage(driver);
		
		registerPage.clickRegisterPage();
		registerPage.clickRegisterBtn();
		
		Assert.assertTrue(registerPage.firstNameErrorMessage(), "❌ First Name error not displayed.");
		Assert.assertTrue(registerPage.lastNameErrorMessage(), "❌ Last Name error not displayed.");
		Assert.assertTrue(registerPage.emailIsRequiredErrorMessage(), "❌ Email error not displayed.");
		Assert.assertTrue(registerPage.passwordIsRequiredErrorMessage(), "❌ Password error not displayed.");
		
		test.pass("All required field validations appeared as expected.");
	}
	
	
	
	
	
//	@DataProvider(name="RegisterData")
//	public Object[][] getData() {
//		return new Object[][] {
//			{"Raizel", "Cadiz", "rcadiz@sample.com", "Hex Corp.", "12121212", "12121212"},
//			{"Raizel21", "Cadiz", "rcadiz21@sample.com", "Hex Corp.", "12121212qw", "12121212"},
//			
//		};
//	}
	
//	@Test(dataProvider="RegisterData")
//	public void testValidRegister(String firstName,
//									String lastName,
//							        String email,
//							        String companyName,
//							        String password,
//							        String confirmPassword) {
//		Log.info("Starting register test...");
//		test = ExtentReportManager.createTest("Register Test");
//		
//		test.info("Navigate to URL");
//		RegisterPage registerPage = new RegisterPage(driver);
//		
//		test.info("Clicking on Reegister link");
//		registerPage.clickRegisterPage();
//		
//		Log.info("Adding personal details");
//		test.info("Adding personal details");
//		registerPage.selectGender();
//		test.info("Gender Selected");
//		Assert.assertTrue(registerPage.isMaleGenderSelected(), "❌ Gender radio button (Male) was not selected.");
//		
//		registerPage.enterFirstName(firstName);
//		test.info("First name Entered Successfully");
//		registerPage.enterLastName(lastName);
//		test.info("Last name Entered Successfully");
//		registerPage.enterEmail(email);
//		test.info("Email Entered Successfully");
//		
//		Log.info("Adding company details");
//		test.info("Adding company details");
//		registerPage.enterCompanyName(companyName);
//		test.info("Company Name Entered Successfully");
//		
//		registerPage.clickNewsLetter();
//		test.info("Unclick Newsletter button");
//		
//		Log.info("Adding Password");
//		test.info("Adding Password");
//		registerPage.enterPassword(password);
//		test.info("Password Entered Successfully");
//		registerPage.enterConfirmPassword(confirmPassword);
//		test.info("Cofirm Password Entered Successfully");
//		
//		test.info("Clicking on Register button");
//		registerPage.clickRegisterBtn();
//		
//		if (!password.equals(confirmPassword)) {
//		    test.fail("Password mismatch validation failed");
//		    Assert.fail("Password mismatch validation failed");
//		} else {
//		    test.pass("Register Successfully");
//		}
//		
////		Log.info("Register test completed.");
////		test.pass("Register Successfully");
//	}
}
