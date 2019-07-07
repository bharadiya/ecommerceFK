package TestCases;

import org.apache.log4j.xml.DOMConfigurator;

import Logger.Log;
import PageObjects.Login;
import Utility.Constants;
import Utility.Keywords;
import Utility.ReadConfig;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC_Login {

	static {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("TC_Login");
		Keywords.openBrowser("chrome");
		Log.info("Opened Chrome");
		Keywords.openURL("https://www.flipkart.com");
		Log.info("Hit flipkart.com");
	}

	Login l = new Login(Constants.driver);
	ReadConfig rc = new ReadConfig("/home/sb/eclipse-workspace/OnFK/src/Configuration/config.properties");

	@Given("^user enters weburl$")
	public void user_enters_weburl() throws Throwable {
		System.out.println("Now user is on flipkart.com home page");
	}

	@When("^user enters username and password$")
	public void user_enters_username_and_password() throws Throwable {
		// Thread.sleep(8000);
		l.setUsername(rc.getUserName());
		Log.info("Entered username");
		l.setPassword(rc.getPassword());
		Log.info("Entered password");
		System.out.println("Entered username and password");
	}

	@Then("^user should log in$")
	public void user_should_log_in() throws Throwable {
		l.clickLogInButton();
		Log.info("Clicked on Login Button");
		System.out.println("Trying to login");
	}

	@Then("^user should get invalid username or password message$")
	public void user_should_get_invalid_username_or_password_message() throws Throwable {
		System.out.println("Login Success");
	}

	@Given("^User is on Home Page of fk$")
	public void user_is_on_Home_Page_of_fk() throws Throwable {
		System.out.println("Entered flipkart.com");
	}

	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		System.out.println("Navigated to Home Page");
	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String username, String password) throws Throwable {
		l.setUsername(username);
		l.setPassword(password);
		l.clickLogInButton();
	}

	@Then("^Message should display login successfully$")
	public void message_should_display_login_successfully() throws Throwable {
		System.out.println("Login Successfully");
	}
}
