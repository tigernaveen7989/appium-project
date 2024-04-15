package ecommerce;

import java.lang.reflect.Method;
import java.net.URL;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.rapidai.jsonhandler.JsonProcessor;
import com.rapidai.pageobjects.SwagLagsLoginPage;
import com.rapidai.utils.Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
	public AppiumDriver driver;
	public SwagLagsLoginPage swagLagsLoginPage;
	public JsonProcessor jsonProcessor;
	String TCName;
	ExtentSparkReporter htmlReporter;

	ExtentReports extent;
	// helps to generate the logs in the test report.
	ExtentTest test;

	@BeforeMethod
	public void initializeDriver(Method method) throws Exception {
		driver = Driver.getInstance();
		loadPageObjects();
		TCName = method.getName();
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") +"/target/testreport/extent-report.html");
		 
        //initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        //configuration items to change the look and feel
        //add content, manage tests etc
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        
        test = extent.createTest("Test Case 1", "The test case 1 has passed");
        
		Thread.sleep(5000);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
		extent.flush();
	}

	public void loadPageObjects() throws Exception {
		swagLagsLoginPage = new SwagLagsLoginPage(driver);
	}

}
