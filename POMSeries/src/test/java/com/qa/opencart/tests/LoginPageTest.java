package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.listeners.TestAllureListener;
import com.qa.opencart.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic 100: Design Open Cart Application - Login Page")
@Story("US 101: Open Cart Login Design with Multiple Features")
@Listeners(TestAllureListener.class)
public class LoginPageTest extends BaseTest {
	
	@Description("Login Page Title Test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String actualTitle = loginPage.getLoginPageTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Description("Login Page URL Test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void loginPageUrlTest() {
		Assert.assertTrue(loginPage.getLoginPageUrl());
	}
	
	@Description("Forgot Password Link Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 3)
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
	}
	
	@Description("Register Link Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 4)
	public void registerLinkTest() {
		Assert.assertTrue(loginPage.isRegisterLinkExist());
	}
	
	@Description("Login Test with Correct Credentials")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 5)
	public void loginTest() throws InterruptedException {
		accountsPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertEquals(accountsPage.getAccountPageTitle(), Constants.ACCOUNTS_PAGE_TITLE);
	}
	
}
