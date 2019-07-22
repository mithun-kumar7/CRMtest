package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CRMmainPage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	CRMmainPage mainPage;
	LoginPage loginPage;
	
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		mainPage=new CRMmainPage();
		loginPage=mainPage.clickOnLoginOption();
	}
	
	@Test
	public void loginPageTitleTest() {
		String title=loginPage.loginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "CRM");
	}
	
	@Test
	public void emailAttributeTest() {
		String emailAttribute=loginPage.emailAttribute();
		System.out.println(emailAttribute);
		Assert.assertEquals(emailAttribute, "E-mail address");
	}
	
	@Test
	public void passwordAttributeTest() {
		String passwordAttribute=loginPage.passwordAttribute();
		System.out.println(passwordAttribute);
		Assert.assertEquals(passwordAttribute, "Password");
	}
	
	@Test
		public void loginTest(){
			loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
