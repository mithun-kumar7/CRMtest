package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CRMmainPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	CRMmainPage mainPage;
	LoginPage loginPage;
	HomePage homePage;
	
	
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage= new LoginPage();
		mainPage=new CRMmainPage();
		loginPage=mainPage.clickOnLoginOption();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test
	public void homePageTitleTest() {
		String title=homePage.verifyHomePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "CRM");
		}
	
	@Test
	public void verifyUserLabelTest() {
		String name=homePage.verifyUserLabel();
		System.out.println(name);
		Assert.assertEquals(name, "Mithun Kumar");
	}
	
	
	@Test
	public void contactsLinkTest() throws InterruptedException {
		homePage.contactsLink();
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
