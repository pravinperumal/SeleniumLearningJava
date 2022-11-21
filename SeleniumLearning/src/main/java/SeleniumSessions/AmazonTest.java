package SeleniumSessions;

public class AmazonTest {

	public static void main(String[] args) {
		
		BrowserUtil bUtil = new BrowserUtil();
		bUtil.launchBrowser("Edge");
		bUtil.enterUrl("https://www.amazon.com");
		String pageTitle = bUtil.getPageTitle();
		if(pageTitle.equalsIgnoreCase("Amazon")) {
			System.out.println("Correct title");
		}
		String url = bUtil.getCurrentURL();
		System.out.println("The page title is: "+pageTitle);
		System.out.println("The url is: "+url);
		bUtil.closeBrowser();
	}
}
