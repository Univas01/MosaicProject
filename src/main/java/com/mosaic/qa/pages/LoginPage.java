package com.mosaic.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mosaic.qa.base.TestBase;
import com.mosaic.qa.util.TestUtil;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//input[@placeholder='username']")
	WebElement userNameField;

	@FindBy(xpath = "//input[@placeholder='password']")
	WebElement passwordField;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement submitBtn;

	@FindBy(xpath = "//input[@aria-label='Search']")
	WebElement searchField;

	@FindBy(xpath = "//a[contains(text(), 'Sign out')]")
	WebElement signOutBtn;

	@FindBy(xpath = "//a[contains(text(), 'Acme corporation')]")
	WebElement pageHeader;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean verifyPageHeader() {
		return pageHeader.isDisplayed();
	}

	public void performSearchOperation(String enterValue) {
		searchField.sendKeys(enterValue);
		TestUtil.clickOnNonJSObject(searchField);
	}
	
	public void signOut(){
		TestUtil.clickOnNonJSObject(signOutBtn);
	}
	
	public HomePage loginFunction(String userName, String password){
		TestUtil.clickOnNonJSObject(submitBtn);
		return new HomePage();
	}

}
