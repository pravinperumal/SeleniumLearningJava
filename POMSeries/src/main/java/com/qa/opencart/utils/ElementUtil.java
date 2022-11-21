package com.qa.opencart.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.utils.Errors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;
	private JavaScriptUtil jsUtil;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		jsUtil = new JavaScriptUtil(driver);
	}

	public static By getBy(String locatorType, String locatorValue) {
		By locator = null;

		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "classname":
			locator = By.className(locatorValue);
			break;
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
		case "cssselector":
			locator = By.cssSelector(locatorValue);
			break;
		case "linktext":
			locator = By.linkText(locatorValue);
			break;
		case "partiallinktext":
			locator = By.partialLinkText(locatorValue);
			break;
		case "tagname":
			locator = By.tagName(locatorValue);
			break;

		default:
			System.out.println("Please pass the right locator type and value...");
			break;
		}
		return locator;
	}

	public WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		if (Boolean.parseBoolean(DriverFactory.highlight)) {
			jsUtil.flash(element);
		}
		return element;
	}

	public WebElement getElement(By locator, int timeout) {
		return doPresenceOfElementLocated(locator, timeout);
	}

//	public WebElement getElement(By locator) {
//		WebElement element = null;
//		if(driver.findElement(locator) != null)
//			element = driver.findElement(locator);
//		else
//			System.out.println("The element is not found. Incorrect locator sent. Returning null element");
//		return element;		
//	}

	public WebElement getElement(String locatorType, String locatorValue) {
		return driver.findElement(getBy(locatorType, locatorValue));
	}

	public List<WebElement> getElements(By locator) {
		List<WebElement> elements = driver.findElements(locator);
		return elements;
	}

	public List<WebElement> getElements(String locatorType, String locatorValue) {
		List<WebElement> elements = driver.findElements(getBy(locatorType, locatorValue));
		return elements;
	}

	public int getElementsCount(By locator) {
		List<WebElement> elements = driver.findElements(locator);
		return elements.size();
	}

	public void doClearMethod(By locator) {
		getElement(locator).clear();
	}

	public void doSendKeys(String locatorType, String locatorValue, String value) {
		getElement(locatorType, locatorValue).clear();
		getElement(locatorType, locatorValue).sendKeys(value);
	}

	public void doSendKeys(By locator, String value) {
		doClearMethod(locator);
		doPresenceOfElementLocated(locator).sendKeys(value);
	}

	public void doSendKeys(By locator, String value, int timeout) {
		doClearMethod(locator);
		doPresenceOfElementLocated(locator, timeout).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public void doClick(String locatorType, String locatorValue) {
		getElement(locatorType, locatorValue).click();
	}

	public void doClick(By locator, int timeout) {
		doPresenceOfElementLocated(locator, timeout).click();
	}

	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	public String getAttributeValue(By locator, String attrName) {
		String attValue = getElement(locator).getAttribute(attrName);
		System.out.println(attValue);
		return attValue;
	}

	public boolean doIsElementDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public boolean doIsElementDisplayed(String locatorType, String locatorValue) {
		return getElement(locatorType, locatorValue).isDisplayed();
	}

	public void ifElementExist(By locator) {
		int elementCount = getElementsCount(locator);
		System.out.println("Total elements found: " + elementCount);
		if (elementCount >= 1) {
			System.out.println("Element is found. " + locator);
		} else {
			System.out.println("Element is not found..." + locator);
		}
	}

	public List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextLinks = new ArrayList<String>();
		for (WebElement e : eleList) {
			String eleText = e.getText();
			if (!eleList.isEmpty()) {
				eleTextLinks.add(eleText);
			}
		}
		return eleTextLinks;
	}

	/******************************* DropDown Utils *******************************/

	public void doDropDownSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void doDropDownSelectByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}

	public void doDropDownSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public void doSelectDropDownValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		System.out.println("The size of the list is: " + optionsList.size());
		int count = 0;
		for (WebElement option : optionsList) {
			System.out.println(count + "::" + option.getText());
			count++;
			if (option.getText().contains(value)) {
				option.click();
				break;
			}
		}
	}

	public void SelectDropDownWithoutUsingSelect(By locator, String value) {
		List<WebElement> elementList = getElements(locator);
		System.out.println(elementList.size());
		for (WebElement e : elementList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

	/******************************* Links to Utils *******************************/

	public List<String> getLinksTextList(By locator) {
		List<WebElement> linksList = getElements(locator);
		List<String> linksTextList = new ArrayList<String>();
		System.out.println(linksList.size());
		for (WebElement e : linksList) {
			String text = e.getText().trim();
			linksTextList.add(text);
		}
		return linksTextList;
	}

	public void clickOnElement(By locator, String linkText) {
		List<WebElement> langList = getElements(locator);
		System.out.println(langList.size());
		for (WebElement e : langList) {
			String text = e.getText().trim();
			if (text.equals(linkText)) {
				e.click();
			}
		}
	}

	/**********************************
	 * WebTable Util
	 **********************************/
	public void printTable(By rowXpath, By columnXpath, String beforeXpath, String afterXpath) {
		int rowCount = getElements(rowXpath).size();
		int colCount = getElements(columnXpath).size();
		System.out.println();
		for (int rowNo = 2; rowNo <= rowCount; rowNo++) {
			for (int columnNo = 1; columnNo <= colCount; columnNo++) {
				String xpath = beforeXpath + rowNo + afterXpath + columnNo + "]";
				String text = doGetText(By.xpath(xpath));
				System.out.print(text + ", ");
			}
			System.out.println();
		}
	}

	/**********************************
	 * Actions Util
	 **********************************/
	public void doMoveToElement(By locator) {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(locator)).perform();
	}

	public void doClickOnChildMenu(By parentMenuLocator, By childMenuLocator) throws InterruptedException {
		doMoveToElement(parentMenuLocator);
		Thread.sleep(3000);
		doClick(childMenuLocator);
	}

	public void doActionSendKeys(By locator, String value) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(locator), value).build().perform();
	}

	public void doActionSendKeysOnActiveElement(By locator, String value) {
		Actions action = new Actions(driver);
		action.click(getElement(locator)).sendKeys(value).build().perform();
	}

	public void doActionClick(By locator) {
		Actions action = new Actions(driver);
		action.click(getElement(locator)).build().perform();
	}

	public void doActionMoveToElementClick(By locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(locator)).click().build().perform();
	}

	/****************************** Element Utils ******************************/

	public WebElement doPresenceOfElementLocated(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public WebElement doPresenceOfElementLocated(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public WebElement doPresenceOfElementLocated(By locator, int timeout, long intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout), Duration.ofMillis(intervalTime));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public WebElement isElementVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement isElementVisible(By locator, int timeout, long intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(intervalTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public WebElement waitForElementToBeVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public List<WebElement> waitForElementsToBeVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public List<WebElement> waitForElementsToBeVisible(By locator, int timeout, long intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout), Duration.ofMillis(intervalTime));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public List<String> getElementsTextListWithWait(By locator, int timeout) {
		List<WebElement> eleList = waitForElementsToBeVisible(locator, timeout);
		List<String> eleListText = new ArrayList<String>();
		for (WebElement webEle : eleList) {
			String text = webEle.getText();
			eleListText.add(text);
		}
		return eleListText;
	}

	/******************************
	 * Wait Util for Non-WebElements
	 ******************************/

	public List<String> getElementsTextListWithWait(By locator, int timeout, long intervalTime) {
		List<WebElement> eleList = waitForElementsToBeVisible(locator, timeout, intervalTime);
		List<String> eleListText = new ArrayList<String>();
		for (WebElement webEle : eleList) {
			String text = webEle.getText();
			eleListText.add(text);
		}
		return eleListText;
	}

	public boolean waitForURLToContain(String urlFraction, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.urlContains(urlFraction));
	}

	public boolean waitForURLToBe(String url, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.urlToBe(url));
	}

	public String doGetTitleWithFraction(String titleFraction, int timeout) {
		if (waitForTitleContains(titleFraction, timeout))
			return driver.getTitle();
		return null;
	}

	public String doGetTitle(String titleFraction, int timeout) {
		if (waitForTitleToBe(titleFraction, timeout))
			return driver.getTitle();
		return null;
	}

	public boolean waitForTitleContains(String titleFraction, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.titleContains(titleFraction));
	}

	public boolean waitForTitleToBe(String titleFraction, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.titleIs(titleFraction));
	}

	public Alert waitForAlert(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public String getAlertText(int timeout) {
		return waitForAlert(timeout).getText();
	}

	public void doAlertAccept(int timeout) {
		waitForAlert(timeout).accept();
	}

	public void doAlertDismiss(int timeout) {
		waitForAlert(timeout).dismiss();
	}

	public void enterAlertText(String text, int timeout) {
		waitForAlert(timeout).sendKeys(text);
		;
	}

	public void waitForFrameByNameOrID(String nameOrID, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrID));
	}

	public void waitForFrameByLocator(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	public void waitForFrameByIndex(int frameIndex, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}

	public void waitForFrameByElement(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}

	public void clickElementWhenReady(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	public WebElement waitForElementPresentUsingFluentWait(By locator, int timeout, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).withMessage(Errors.ELEMENT_NOT_FOUND_ERROR_MESSAGE);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public WebElement waitForElementPresentUsingWebDriverWait(By locator, int timeout, int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).withMessage(Errors.ELEMENT_NOT_FOUND_ERROR_MESSAGE);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/********************************************
	 * Custom Wait
	 ********************************************/

	public WebElement retryingElement(By locator, int timeout, long pollingTime) {
		WebElement element = null;
		int attempts = 0;

		while (attempts < timeout) {
			try {
				element = getElement(locator);
				break;
			} catch (NoSuchElementException e) {
				System.out.println("The element is not found in attempt: " + attempts + " : " + locator);
				attempts++;
				try {
					Thread.sleep(pollingTime);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}

		if (element == null) {
			try {
				throw new Exception("ELEMENTNOTFOUNDEXCEPTION");
			} catch (Exception e) {
				System.out.println("Element is not found exception... tried for : " + timeout
						+ " with the interval of : " + attempts);
			}
		}
		return element;
	}

	public WebElement retryingElement(By locator, int timeout) {
		WebElement element = null;
		int attempts = 0;

		while (attempts < timeout) {
			try {
				element = getElement(locator);
				break;
			} catch (NoSuchElementException e) {
				System.out.println("The element is not found in attempt: " + attempts + " : " + locator);
				attempts++;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}

		if (element == null) {
			try {
				throw new Exception("ELEMENTNOTFOUNDEXCEPTION");
			} catch (Exception e) {
				System.out.println("Element is not found exception... tried for : " + timeout
						+ " with the interval of : " + attempts);
			}
		}
		return element;
	}

	

}
