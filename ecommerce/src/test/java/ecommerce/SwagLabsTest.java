package ecommerce;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.URL;
import java.lang.reflect.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import java.net.MalformedURLException;
import io.appium.*;

public class SwagLabsTest extends BaseTest{
	
	static Logger log = LogManager.getLogger(SwagLabsTest.class);

	@Test
	public void verify_login_using_valid_username_and_password() throws Exception {
		// TODO Auto-generated method stub
		swagLagsLoginPage.enterUserName("standard-user");
		test.log(Status.PASS, "Enter username");
		swagLagsLoginPage.enterPasswordEditbox("secret-sauce");
		test.log(Status.FAIL, "Enter password");
		swagLagsLoginPage.clickOnLoginButton();
		test.log(Status.INFO, "clicked on login button");
		Thread.sleep(5000);
	}

}
