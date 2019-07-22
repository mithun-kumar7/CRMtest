package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CRMmainPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	CRMmainPage mainPage;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	String sheetName = "contacts";
	
	public ContactsPageTest(){
		super();		
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		mainPage=new CRMmainPage();
		loginPage=new LoginPage();
		homePage=new HomePage();
		
		loginPage=mainPage.clickOnLoginOption();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage=homePage.contactsLink();
	}
	
	@Test
	public void contactsLabelTest() {
		String label=contactsPage.verifyContactsLabel();
		System.out.println(label);
		Assert.assertEquals(label, "Contacts", "Label is not correct");
	}
	/*
	@Test
	public void selectSingleContactsTest() throws InterruptedException{
		driver.navigate().refresh();
		Thread.sleep(6000);
		contactsPage.selectContactsByName("Mithun");
		Thread.sleep(2000);
	}
	
	@Test
	public void selectMultipleContactsTest() throws InterruptedException{
		driver.navigate().refresh();
		Thread.sleep(6000);
		contactsPage.selectContactsByName("Mithun");
		contactsPage.selectContactsByName("Devendra");
		Thread.sleep(2000);
	}
	
	*/
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(dataProvider="getCRMTestData")
	public void validateCreateNewContact(String ftName, String ltName, String mail, String add, String departmnt){
		contactsPage.clickonNewLink();
		//contactsPage.createNewContact("Arpita", "Murty", "arpitha@gmail.com", "Rajajinagar", "BCOM");
	
		contactsPage.createNewContact(ftName, ltName, mail, add, departmnt);
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
