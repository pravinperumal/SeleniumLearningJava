package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.Errors;

public class AccountsPageTest extends BaseTest {
	
	@BeforeClass
	public void accountPageSetup() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void accPageTitlePage() {
		String accPageTitle = accountsPage.getAccountPageTitle();
		System.out.println("Accounts page title : "+accPageTitle);
		Assert.assertEquals(accPageTitle, Constants.ACCOUNTS_PAGE_TITLE);
	}
	
	//The page header has gone missing. This test should instead check for the presence of a logo
	@Test
	public void accPageHeaderTest() {
		String header = accountsPage.getAccountsPageHeader();
		System.out.println("Acc page header is: "+header);
		Assert.assertEquals(header, Constants.ACCOUNTS_PAGE_HEADER, Errors.ACC_PAGE_HEADER_NOT_FOUND_ERROR_MESSAGE);
	}
	
	@Test
	public void isLogoutExistTest() {
		Assert.assertTrue(accountsPage.isLogoutLinkExist());
	}
	
	@Test
	public void accPageSecsTest() {
		List<String> actAccSecList = accountsPage.getAccountSecList();
		Assert.assertEquals(actAccSecList, Constants.getExpectedAccSecList());
	}
	
	@DataProvider
	public Object[][] productData() {
		return new Object[][] {
			{"Macbook Pro"},
			{"Apple"},
			{"Samsung"},
		};
	}
	
	@Test(priority = 5, dataProvider = "productData")
	public void searchTest(String productName) {
		searchResultsPage = accountsPage.doSearch("Macbook Pro");
		Assert.assertTrue(searchResultsPage.getProductsListCount()>0);
	}
	
	@DataProvider
	public Object[][] productSelectData() {
		return new Object[][] {
			{"Macbook Pro", "Macbook Pro"},
			{"iMac", "iMac"},
			{"Samsung", "Samsung SyncMaster 941BW"},
			{"Apple", "Apple Cinema 30"},
		};
	}
	
	@Test(priority = 6, dataProvider = "productSelectData")
	public void selectProductTest(String productName, String mainProductName) {
		searchResultsPage = accountsPage.doSearch(productName);
		productInfoPage = searchResultsPage.selectProduct(mainProductName);
		Assert.assertEquals(productInfoPage.getProductHeader(), mainProductName); 
	}
}
