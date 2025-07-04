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
		
		loginPage.enterEmail("john.doe" + System.currentTimeMillis() + "@mail.com");
		
		loginPage.enterPassword("Test@1234");
		
		loginPage.clickShowPassword();
		
		test.pass("Login Successfully");
	}
}
