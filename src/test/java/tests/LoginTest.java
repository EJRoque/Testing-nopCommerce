package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportManager;

public class LoginTest extends BaseTest{
	
	@Test
	public void testSuccessfulLogin() {
		test = ExtentReportManager.createTest("Test Successful Log in");
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.clickLoginPage();
		loginPage.enterEmail("john.doe23@mail.com");
		loginPage.enterPassword("Test@1234");
		loginPage.clickShowPassword();
		loginPage.clickRememberMe();
		loginPage.clickLoginBtn();
		
		test.pass("Login Successfully");
	}
	
	@Test
	public void testWrongEmail() {
		test = ExtentReportManager.createTest("Test Wrong Email");
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.clickLoginPage();
		loginPage.enterEmail("wrong.email@mail.com");
		loginPage.enterPassword("Test@1234");
		loginPage.clickShowPassword();
		loginPage.clickLoginBtn();
		
		if (loginPage.isLoginErrorMessageDisplayed()) {
			test.pass("Login error message appeared as expected.");
		} else {
			test.fail("❌ Expected error message was not displayed.");
			Assert.fail("❌ Expected error message was not displayed.");
		}
	}
	
	@Test
	public void testWrongPassword() {
		test = ExtentReportManager.createTest("Test Wrong Password");
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.clickLoginPage();
		loginPage.enterEmail("john.doe23@mail.com");
		loginPage.enterPassword("WrongPassword");
		loginPage.clickShowPassword();
		loginPage.clickLoginBtn();
		
		if (loginPage.isLoginErrorMessageDisplayed()) {
			test.pass("Login error message appeared as expected.");
		} else {
			test.fail("❌ Expected error message was not displayed.");
			Assert.fail("❌ Expected error message was not displayed.");
		}
	}
	
	@Test
	public void testEmptyEmailField() {
		test = ExtentReportManager.createTest("Test Empty Email Field");
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.clickLoginPage();
		loginPage.enterPassword("Test@1234");
		loginPage.clickShowPassword();
		loginPage.clickLoginBtn();
		
		if (loginPage.isEmailErrortextDisplayed()) {
			test.pass("Email error message appeared as expected.");
		} else {
			test.fail("❌ Expected error message was not displayed.");
			Assert.fail("❌ Expected error message was not displayed.");
		}
	}
	
	@Test
	public void testEmptyPasswordField() {
		test = ExtentReportManager.createTest("Test Empty Password Field");
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.clickLoginPage();
		loginPage.enterEmail("john.doe23@mail.com");
		loginPage.clickLoginBtn();
		
		if (loginPage.isLoginErrorMessageDisplayed()) {
			test.pass("Login error message appeared as expected.");
		} else {
			test.fail("❌ Expected error message was not displayed.");
			Assert.fail("❌ Expected error message was not displayed.");
		}
	}
}
