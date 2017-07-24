package org.qait.coach.test.coach2;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.WebDriver;
import org.qait.coach.Actions.coach2.CoachCheckOut;
import org.qait.coach.Actions.coach2.CoachGiftCard;
import org.qait.coach.Actions.coach2.ConfigPropertyReader;
import org.qait.coach.Actions.coach2.Driver;
import org.qait.coach.Actions.coach2.ExcelFile;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCoachCheckOut {

	CoachGiftCard coachGCObj;
	ExcelFile efObj;
	Driver driverobj;
	CoachCheckOut coachCheckOutObject;
	 ConfigPropertyReader configReaderObj;
	int sleepTime = 5000;
	WebDriver driver;
	String GiftcardTitle = "SEND STYLE";
	String giftCardDescription = "The luxury of choice is a wonderful gift.";
	String giftCard = "GIFT CARDS";
	String thankYou = "THANK YOU FOR YOUR ORDER.";
	String cursor = System.getProperty("cursor", "1");

	@BeforeTest
	void setup() {
		driverobj = new Driver();
		efObj = new ExcelFile();
		 configReaderObj=new ConfigPropertyReader();
		 
	}

	@Test(priority = 0)
	void testLaunchApplication() {
		driver = driverobj.LaunchApplication();
		coachGCObj = new CoachGiftCard(driver);
		coachCheckOutObject = new CoachCheckOut(driver);
		Reporter.log("Successfully Launched Coach Website");
	}

	@Test(priority = 1)
	void testClickOnSaleButton() {
		coachCheckOutObject.clickOnSaleButton();
		Reporter.log("User clicks on Sale button");
	}

	@Test(priority = 2)
	void testClickOnCrossSign() {
		if(!((configReaderObj.getOptionValue("browser").toString()).equalsIgnoreCase("chrome"))){
		coachCheckOutObject.clickOnCloseButton();
		Reporter.log("User clicks on close button for closing pop Window");
		}
	}

	
	@Test(priority = 3)
	void TestClickOnSelectedBoot() {
		coachCheckOutObject.clickOnSelectedBoot();
		Reporter.log("User clicks on Boot icon");
		
	}

	@Test(priority = 4)
	void TestClickOnSizeButton() throws InterruptedException {
		coachCheckOutObject.clickOnSizeButton();
		Reporter.log("User click on  Select Size button");
	}

	@Test(priority = 5)
	void TestSetSizeOfBoot() {
		coachCheckOutObject.setSizeOfBoot();
		Reporter.log("User set the size");
	}

	@Test(priority = 6)
	void TestClickOnAddToBag() throws InterruptedException {
		coachCheckOutObject.clickOnAddToBag();
		Reporter.log("User click on  Add to bag button");
	}

	@Test(priority = 7)
	void testClickOnBagButton() throws InterruptedException {
		coachCheckOutObject.clickOnBagButton();
		Reporter.log("User click on  bag icon");
	}

	@Test(priority = 8)
	void testClickOnCheckButton() {
		coachCheckOutObject.clickOnCheckOut();
		Reporter.log("User click on checkout button");
		
	}

	@Test(priority = 9)
	void testSetFirstName() {
		coachCheckOutObject.setFirstName();
		Reporter.log("User set the First Name value");
	}

	@Test(priority = 10)
	void testSetLastName() {
		coachCheckOutObject.setLastName();
		Reporter.log("User set the Last Name value");
	}

	@Test(priority = 11)
	void testSetAdress() {
		coachCheckOutObject.setAdress();
		Reporter.log("User set the Address value");
	}

	@Test(priority = 12)
	void testSetZipCode() {
		coachCheckOutObject.setZipCode();
		Reporter.log("User set the zip code value");
	}

	@Test(priority = 13)
	void testSetPhoneNumber() {
		coachCheckOutObject.setPhoneNumber();
		Reporter.log("User set the Phone Number value");
	}

	@Test(priority = 14)
	void testClickOnContinue() throws InterruptedException {
		coachCheckOutObject.clickOnContinue();
		Reporter.log("User click on continue button");
	}

	@Test(priority = 15)
	void testsetCardNumber() {
		coachCheckOutObject.setCardNumber(efObj.getCreditCardNumber(Integer.parseInt(cursor)));
		Reporter.log("User set the credit card number value");
	}
	

	@Test(priority = 16)
	void testSetMonth() {
		coachCheckOutObject.setMonth();
		Reporter.log("User set the month value");
	}

	@Test(priority = 17)
	void testSetYear() {
		coachCheckOutObject.setYear();
		Reporter.log("User set the year value");
	}

	@Test(priority = 18)
	void testSetSecurityCode() {
		coachCheckOutObject.setSecurityCode(efObj.getCreditCardSecurityNumber(Integer.parseInt(cursor)));
		Reporter.log("User set the security code value");
	}
	

	@Test(priority = 19)
	void testSetEmailAddress() {
		coachCheckOutObject.setEmailAddress();
		Reporter.log("User set the Email Address value");
	}

	@Test(priority = 20)
	void testSetConfirmEmailAddress() {
		coachCheckOutObject.setConfirmEmailAddress();
		Reporter.log("User set the confirm email Address value");
	}

	@Test(priority = 21)
	void testClickOnPaymentContinue() throws InterruptedException {
		coachCheckOutObject.clickOnContinue();
		Reporter.log("User click on continue Payment Button");
	}

	@Test(priority = 22)
	void testSetSecurityCodes() {
		coachCheckOutObject.setSecurityCode(efObj.getCreditCardSecurityNumber(Integer.parseInt(cursor)));
		Reporter.log("User set the security code value");
	}


	@Test(priority = 23)
	void testClickOnPaymentContinues() throws InterruptedException {
		coachCheckOutObject.clickOnContinue();
		Reporter.log("User click on continu button");
	}

	@Test(priority = 24)
	void testClickOnPlaceOrder() {
		coachCheckOutObject.clickOnPlaceOrder();
		assertEquals("check your order is placed", thankYou, coachCheckOutObject.getThankYouText());
    	Reporter.log("User click on Placed order button");
	}

	}
