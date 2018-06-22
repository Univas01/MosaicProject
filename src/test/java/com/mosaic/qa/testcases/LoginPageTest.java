package com.mosaic.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import com.mosaic.qa.base.TestBase;
import com.mosaic.qa.pages.LoginPage;
import com.mosaic.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	TestUtil testUtil;
	
	public LoginPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
	}
	
	// Test is to verify the page title
	@Test (priority = 1)
	public void loginPageTitleTest(){
		String title = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(title, "Dashboard Template for Bootstrap");
	}
	
	// Test is to verify that page header is displaying
	@Test (priority = 2)
	public void pageHeaderTest(){
		boolean flag = loginPage.verifyPageHeader();
		Assert.assertTrue(flag);
	}
	
	// Test is to verify search operation can be performed
	@Test (priority = 3)
	public void searchOperationTest(){
		loginPage.performSearchOperation("Type your search criteria here");
	}
	
	// Test is to verify users can login
	@Test (priority = 4)
	public void loginFunctionTest(){
		loginPage.loginFunction(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
