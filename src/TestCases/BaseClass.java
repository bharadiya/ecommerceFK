package TestCases;

import org.apache.log4j.xml.DOMConfigurator;

import Logger.Log;
import Utility.Keywords;
import cucumber.api.java.Before;

public class BaseClass {
	@Before("@Login")
	public void openBrowser() {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("TC_Login");
		Keywords.openBrowser("chrome");
		Log.info("Opened Chrome");
		Keywords.openURL("https://www.flipkart.com");
		Log.info("Hit flipkart.com");
	}
	
	@Before("@Login")
	public void openFirefox() {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("TC_Login");
		Keywords.openBrowser("firefox");
		Log.info("Opened Chrome");
		Keywords.openURL("https://www.flipkart.com");
		Log.info("Hit flipkart.com");
	}
}
