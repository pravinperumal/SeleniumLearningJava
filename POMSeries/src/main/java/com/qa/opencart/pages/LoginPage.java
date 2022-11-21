package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {

	// 1. Declare private driver
	private ElementUtil eleUtil;
	private WebDriver driver;

	// 2. Page constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. By locators
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.linkText("Login");
	private By registerLink = By.linkText("Register");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By loginErrorMessage = By.cssSelector("div.alert.alert-danger.alert-dismissible");

	// 4. Page Actions
	@Step("Getting Login Page Title...")
	public String getLoginPageTitle() {
		return eleUtil.doGetTitle(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}
	
	@Step("Getting Login Page URL...")
	public boolean getLoginPageUrl() {
		return eleUtil.waitForURLToContain(Constants.LOGIN_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);
	}
	
	@Step("Checking forgot password link exists or not...")
	public boolean isForgotPasswordLinkExist() {
		return eleUtil.doIsElementDisplayed(forgotPwdLink);
	}
	
	@Step("Checking Register link exists or not...")
	public boolean isRegisterLinkExist() {
		return eleUtil.doIsElementDisplayed(registerLink);
	}
	
	@Step("Do login with Username: {0} and Password: {1}")
	public AccountsPage doLogin(String usr, String pwd) {
		System.out.println("Login with : " + usr + " and : " + pwd);
		eleUtil.doSendKeys(emailId, usr);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doActionClick(loginBtn);
		return new AccountsPage(driver);
	}
	
	@Step("Do login with wrong Username: {0} and wrong Password: {1}")
	public boolean doLoginWithWrongCredentials(String usr, String pwd) {
		System.out.println("Trying to login with wrong credentials: " + usr + ":" + pwd);
		eleUtil.doSendKeys(emailId, usr);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doActionClick(loginBtn);

		String errorMessage = eleUtil.doGetText(loginErrorMessage);
		System.out.println(errorMessage);
		if (errorMessage.contains(Constants.LOGIN_ERROR_MESSAGE)) {
			System.out.println("Login is not done...");
			return false;
		}
		return true;
	}
	
	@Step("Navigating to registration page...")
	public RegistrationPage goToRegisterPage() {
		eleUtil.doClick(registerLink);
		return new RegistrationPage(driver);
	}
}
