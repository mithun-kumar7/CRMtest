package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CRMmainPage;

public class CRMmainPageTest extends TestBase {
	
	CRMmainPage mainPage;
	
	
	public CRMmainPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		mainPage = new CRMmainPage();	
	}
	
	@Test
	public void CRMmainPageTitleTest(){
		String title=mainPage.validateCRM_MainPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software for any Business");
	}
	
	@Test
	public void crmLogoImageTest(){
		boolean flag = mainPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void validatePhoneNoTest(){
		String mobile = mainPage.validatePhoneNo();
		System.out.println(mobile);
		Assert.assertEquals(mobile, "+1 415 200 2844");
	}
	
	@Test
	public void clickOnLoginOptnTst() {
		mainPage.clickOnLoginOption();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
