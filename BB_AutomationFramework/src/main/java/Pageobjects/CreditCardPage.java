package Pageobjects;

import Utils.UtilityMethods;

public class CreditCardPage {
	static CreditCardPage ccpage;
	
	public String BB_LANDING_PAGE_URL = "https://www.bankbazaar.com";
	public String  GATEWAY_PAGE = "//div[@class='bb-banner-menu-outer']";
	public String CARDS = ".credit-cards-menu";
	public String CREDIT_CARD = "//a[@data-product='credit-cards']";
	public String CC_LANDINGPAGE = "//div[@id='cl-card-comparisons']";
	
	public static String GetPageElement(String element)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		ccpage = new CreditCardPage();
		return (String) ccpage.getClass().getField(element).get(ccpage);
	}
	
	public static void LoadWebUrl(String url) {
		try {
			UtilityMethods.OpenWebUrl(url);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void WaitForPageElement(String locator, String element, int timeout) {
		UtilityMethods.WaitForElement(locator, element, timeout);		
	}

	public static boolean PageElementIsVisible(String locator, String element) {
		return UtilityMethods.ElementVisible(locator, element);
	}

	public static void MouseHoverElementPage(String locator, String element) {	
		UtilityMethods.MouseHoverElement(locator, element);
	}

	public static void ClickElementPage(String locator, String element) {
		UtilityMethods.ClickElement(locator, element);		
	}
}
