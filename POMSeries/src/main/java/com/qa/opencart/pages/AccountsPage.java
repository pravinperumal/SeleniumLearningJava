package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {	
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By header = By.xpath("//img[@class='img-fluid']");
//	private By accountsSections = By.cssSelector("div#content h2");
	private By accountsSections = By.xpath("//h2");
	private By searchField = By.name("search");
	private By searchButton = By.cssSelector("div#search button");
	private By logoutLink = By.linkText("Logout");

	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String getAccountPageTitle() {
		return eleUtil.doGetTitle(Constants.ACCOUNTS_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}
	
	public String getAccountsPageHeader() {
		return eleUtil.doGetText(header);
	}
		
	public boolean isLogoutLinkExist() {
		return eleUtil.doIsElementDisplayed(logoutLink);
	}
	
	public void logout() {
		if(isLogoutLinkExist()) {
			eleUtil.doClick(logoutLink);
		}
	}
	
	public List<String> getAccountSecList() {
		List<WebElement> accountSecList = eleUtil.waitForElementsToBeVisible(accountsSections, 10);
		List<String> accountSecValList = new ArrayList<String>();
		eleUtil.doGetTitleWithFraction(getAccountPageTitle(), 0);
		for(WebElement e: accountSecList) {
			String text = e.getText();
			accountSecValList.add(text);
		}
		return accountSecValList;
	}
	
	public boolean doesSearchExist() {
		return eleUtil.doIsElementDisplayed(searchField);		
	}
	
	public SearchResultsPage doSearch(String productName) {
		System.out.println("Searching for products: "+productName);
		eleUtil.doSendKeys(searchField, productName, 0);
		eleUtil.doClick(searchButton);
		return new SearchResultsPage(driver);
	}

}
