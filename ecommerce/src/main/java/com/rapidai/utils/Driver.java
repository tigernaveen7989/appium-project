package com.rapidai.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Driver {
    private static AppiumDriver driver;
    private static Properties prop = new Properties();
    static Map<String, String> testData = new HashMap<>();

    private Driver() {
        // Private constructor to prevent instantiation from outside
    }

    public static synchronized AppiumDriver getInstance() throws IOException {
        if (driver == null) {
            // Create desired capabilities for your specific platform
        	UiAutomator2Options androidOptions = new UiAutomator2Options();
        	XCUITestOptions iosOptions = new XCUITestOptions();
            androidOptions.setDeviceName(getTestData().get("deviceName"))
            				.setPlatformVersion(getTestData().get("platformVersion"))
            				.setPlatformName("Android")
            				.setAppActivity(getTestData().get("appActivity"))
            				.setAppPackage(getTestData().get("appPackage"))
            				//.setNoReset(true)
            				//.setFullReset(false)
            				.setAutomationName("UiAutomator2");

            // Initialize the Appium driver based on the platform
            if (isAndroidPlatform()) {
                try {
                    driver = new AndroidDriver(new URL("http://localhost:4723/"), androidOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    driver = new IOSDriver(new URL("http://localhost:4723/"), iosOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
        return driver;
    }

    private static boolean isAndroidPlatform() {
        // Add logic to determine the platform (Android or iOS) dynamically
        // For simplicity, assuming Android for now
        return true;
    }
    
    private static Map<String, String> getTestData() throws IOException{
    	FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
    	prop.load(file);
    	testData.put("deviceName", prop.getProperty("deviceName"));
    	testData.put("appActivity", prop.getProperty("appActivity"));
    	testData.put("appPackage", prop.getProperty("appPackage"));
    	testData.put("platformVersion", prop.getProperty("platformVersion"));
    	return testData;
    }
}
