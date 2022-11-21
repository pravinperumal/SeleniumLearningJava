package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class RegistrationPage {

	private ElementUtil eleUtil;

	// Register account
	private By loginPageLink = By.xpath("//a[normalize-space()='login page']");

	// Personal details
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");

	// Password
	private By password = By.id("input-password");

	// Newsletter
	private By subscribeYes = By.id("input-newsletter-yes");
	private By subscribeNo = By.id("input-newsletter-no");

	// Privacy policy and continue
	private By agreeToPrivacyPolicy = By.name("agree");
	private By continueButton = By.xpath("//button[@type='submit']");
	private By successMsg = By.cssSelector("div#content h1");

	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");

	private WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public boolean accountRegistration(String firstName, String lastName, String email, 
			String password, String subscribe) {
		eleUtil.doSendKeys(this.firstName, firstName);
		eleUtil.doSendKeys(this.lastName, lastName);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.password, password);
		if (subscribe.equals("yes")) {
			eleUtil.doClick(subscribeYes);			
		} else {
			eleUtil.doClick(subscribeNo);
		}
		eleUtil.doClick(agreeToPrivacyPolicy);
		eleUtil.doClick(continueButton);
		String message = eleUtil.waitForElementToBeVisible(successMsg, 1000).getText();
		
		if(message.contains(Constants.REGISTER_SUCCESS_MESSAGE)) {
			eleUtil.doClick(logoutLink);
			eleUtil.doClick(registerLink);
			return true;
		}
		return false;
	}

}
