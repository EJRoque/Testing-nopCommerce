package tests;

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
		loginPage.clickLoginBtn();
		
		test.pass("Login Successfully");
	}
	
	@Test
	public void testWrongEmail() {
		test = ExtentReportManager.createTest("Test Successful Log in");
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.clickLoginPage();
		loginPage.enterEmail("wrong.email@mail.com");
		loginPage.enterPassword("Test@1234");
		loginPage.clickShowPassword();
		loginPage.clickLoginBtn();
		
		test.pass("Login Successfully");
	}
	
	@Test
	public void testWrongPassword() {
		test = ExtentReportManager.createTest("Test Successful Log in");
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.clickLoginPage();
		loginPage.enterEmail("john.doe23@mail.com");
		loginPage.enterPassword("WrongPassword");
		loginPage.clickShowPassword();
		loginPage.clickLoginBtn();
		
		test.pass("Login Successfully");
	}
}
