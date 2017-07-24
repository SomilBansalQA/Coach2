package org.qait.coach.Actions.coach2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoachGiftCard {

	ExcelFile efObj;
	WebDriver driver;
	WebDriverWait wait;
	By click_on_gift_cards = By.cssSelector(".footer-lower-wrap [href*='gift-card']");
	By click_on_close_pop_window_sign = By.cssSelector("button[class='icon-coach-close-black']");
	By click_on_check_your_balance = By.cssSelector("#gift-card-balance");
	By set_gift_card_Number = By.cssSelector("#dwfrm_giftcard_inquireBalance_giftcardcode");
	By set_gift_card_pin_Number = By.cssSelector("#dwfrm_giftcard_inquireBalance_giftcardpin");
	By click_on_submit_button = By.xpath(".//button[contains(text(), 'Submit')]");
	By get_gift_card_Title = By.xpath(".//h1[contains(text(),'SEND STYLE')]");
	By get_gift_card_Description = By.xpath(".//div[contains(text(),'The luxury of choice is a wonderful gift.')]");
	By get_gift_card_Text = By.xpath(".//div[contains(text(),'GIFT CARDS')]");
	By get_gift_card_Balance = By.xpath(".//div[@class='row balance-row']/span");

	public CoachGiftCard(WebDriver driver) {
		this.driver = driver;
		efObj = new ExcelFile();
		wait = new WebDriverWait(driver, 30);
	}

	public void clickOnGiftCards() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(click_on_gift_cards)).click();
	}

	public void clickOnCloseButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(click_on_close_pop_window_sign)).click();
	}

	public void clickOnCheckYourBalance() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(click_on_check_your_balance)).click();
	}

	public void setGiftCardNumber(String CardNumber) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(set_gift_card_Number)).sendKeys(CardNumber);
	}

	public void setGiftCardPinNumber(String PinNumber) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(set_gift_card_pin_Number)).sendKeys(PinNumber);
	}

	public void clickOnSubmitButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(click_on_submit_button)).click();
	}

	public void scrollIntoView() throws InterruptedException {
		Thread.sleep(5000);
		((JavascriptExecutor) driver)
				.executeScript("document.getElementById('search-result-content').scrollIntoView(true);");
		Thread.sleep(5000);
	}

	public String getGiftCardTitle() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(get_gift_card_Title));
		String title = driver.findElement(get_gift_card_Title).getText();
		return title;
	}

	public String getGiftCardDescription() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(get_gift_card_Description));
		String description = driver.findElement(get_gift_card_Description).getText();
		return description;
	}

	public String getGiftCardText() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(get_gift_card_Text));
		String cardText = driver.findElement(get_gift_card_Text).getText();
		return cardText;
	}

	public String getGiftCardBalance() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(get_gift_card_Balance));
		String giftCardBalance = driver.findElement(get_gift_card_Balance).getText();
		return giftCardBalance;
	}

	public WebElement isElementLoaded(WebElement elementToBeLoaded) {
		WebElement element = wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
		return element;
	}

	public void giftCardDetails() throws InterruptedException {
		int cursor = 1;
		while (cursor < efObj.getNoOfRows() - 1) {
			clickOnCheckYourBalance();
			setGiftCardNumber(efObj.getGiftCardNumber(cursor));
			setGiftCardPinNumber(efObj.getGiftCardPinNumber(cursor));
			System.out.println("Gift Card No: is " + efObj.getGiftCardNumber(cursor) + "Pin No: "
					+ efObj.getGiftCardPinNumber(cursor));
			clickOnSubmitButton();
			System.out.println(getGiftCardBalance());
			clickOnCloseButton();
			cursor++;

		}
	}
}
