package com.rapidai.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SwagLagsLoginPage extends BasePageObject{
	
	public SwagLagsLoginPage(AppiumDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "test-Username")
	@iOSXCUITFindBy(accessibility = "test-Username")
	private WebElement userNameEditbox;
	@AndroidFindBy(accessibility = "test-Password")
	private WebElement passwordEditbox;
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
	private WebElement loginButton;
	
	public void enterUserName(String userName) {
		sendKeys(userNameEditbox, userName);
	}
	
	public void enterPasswordEditbox(String password) {
		sendKeys(passwordEditbox, password);
	}
	
	public void clickOnLoginButton() {
		click(loginButton);
	}
}
