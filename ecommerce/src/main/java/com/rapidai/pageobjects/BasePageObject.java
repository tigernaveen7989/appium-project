package com.rapidai.pageobjects;

import org.openqa.selenium.WebElement;
import org.testng.*;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePageObject {

	public BasePageObject(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void sendKeys(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public void click(WebElement element) {
		element.click();
	}
}
