package com.mosaic.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mosaic.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//h1[contains(text(), 'Dashboard')]")
	WebElement dashboard;
	
	@FindBy(xpath="//h2[contains(text(), 'rates')]")
	WebElement todaysRate;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}

	public boolean verifyDashboardVisibility(){
		return dashboard.isDisplayed();
	}
	
	public boolean verifyRateVisibility(){
		return todaysRate.isDisplayed();
	}
}
