package org.qait.coach.test.coach2;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.WebDriver;
import org.qait.coach.Actions.coach2.CoachGiftCard;
import org.qait.coach.Actions.coach2.ConfigPropertyReader;
import org.qait.coach.Actions.coach2.Driver;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

class TestCoachGiftCard {
	CoachGiftCard coachGCObj;
	Driver driverobj;
	WebDriver driver;
    ConfigPropertyReader configReaderObj;
	String GiftcardTitle = "SEND STYLE";
	String giftCardDescription = "The luxury of choice is a wonderful gift.";
	String giftCard = "GIFT CARDS";
	String thankYou = "THANK YOU FOR YOUR ORDER.";

	@BeforeTest
	void setup() {
		driverobj = new Driver();
		 configReaderObj=new ConfigPropertyReader();

	}

	@Test(priority = 0)
	void testLaunchApplication() {
		driver = driverobj.LaunchApplication();
		coachGCObj = new CoachGiftCard(driver);
       
		Reporter.log("Successfully Launched Coach Website");
	}

	@Test(priority = 1)
	void testClickOnGiftCards() {
		coachGCObj.clickOnGiftCards();
		Reporter.log("User clicks on GiftCard button");
	}

	@Test(priority = 2)
	void testClickOnCloseButton() {
		if(!((configReaderObj.getOptionValue("browser").toString()).equalsIgnoreCase("chrome"))){
		coachGCObj.clickOnCloseButton();
		Reporter.log("User clicks on close button for closing pop Window");
		}
		
	}

	@Test(priority = 3)
	void testForVerifyGiftCardPage() throws InterruptedException {
		coachGCObj.scrollIntoView();
		assertEquals("check GiftcardTitle", GiftcardTitle, coachGCObj.getGiftCardTitle());
		assertEquals("check giftCardDescription", giftCardDescription, coachGCObj.getGiftCardDescription());
		assertEquals("check giftCardText", giftCard, coachGCObj.getGiftCardText());
		Reporter.log("Verifying gift card Page");	
	}

	@Test(priority = 4)
	void TestForCheckingAllGiftCards() throws InterruptedException {
		coachGCObj.giftCardDetails();
		Reporter.log("Verifying all gift card is working or not");
	}

}
