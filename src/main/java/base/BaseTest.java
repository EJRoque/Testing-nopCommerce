package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import utils.Log;
import utils.ExtentReportManager;

public class BaseTest {

	protected WebDriver driver;
	protected static ExtentReports extent;
	protected ExtentTest test;
	
	@BeforeSuite
	public void setupReport() {
		extent = ExtentReportManager.getReportInstance();
	}
	
	@AfterSuite
	public void tearDownReport() {
		extent.flush();
		//String reportPath = ExtentReportManager.getReportInstance();
		//EmailUtils.sendTestReport(reportPath);
	}
	
	@BeforeMethod
	public void setup() {
		Log.info("Setting up WebDriver...");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Log.info("Navigating to test URL");
		driver.get("https://demo.nopcommerce.com/");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = ExtentReportManager.captureScreenshot(driver, "Login Failure");
			test.fail("Test Failed. Check screenshot",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		
		if(driver != null) {
			Log.info("Closing the Browser");
			//driver.quit();
		}
	}
}
