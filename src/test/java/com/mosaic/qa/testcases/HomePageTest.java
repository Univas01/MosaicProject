package com.mosaic.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import com.mosaic.qa.base.TestBase;
import com.mosaic.qa.pages.HomePage;
import com.mosaic.qa.pages.LoginPage;
import com.mosaic.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	TestUtil testUtil;
	HomePage homePage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		homePage = loginPage.loginFunction(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	// To verify user have successfully login and Dashboard header is visible
	@Test(priority = 1)
	public void dashboardVisibilityTest(){
		boolean flag = homePage.verifyDashboardVisibility();
		Assert.assertTrue(flag);
	}
	
	// To verify user have successfully login and Today's rates header is visible
	@Test (priority = 2)
	public void rateVisibilityTest(){
		boolean flag = homePage.verifyRateVisibility();
		Assert.assertTrue(flag);
	}
	
	// To verify Dashboard header is not visible after login out.
	// NOTE: Sign Out button is not responding so this test will fail
	@Test  (priority = 3)
	public void signOutTest(){
		boolean flag = homePage.verifyDashboardVisibility();
		loginPage.signOut();
		Assert.assertFalse(flag);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
