package TestCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Logger.Log;
import PageObjects.MyProfile;
import Utility.Constants;
import Utility.Keywords;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC_MyProfile {
	@Given("^user clicks on my profile$")
	public void user_clicks_on_my_profile() throws Throwable {
		Thread.sleep(3000);
		System.out.println("User is on my profile section");
	}

	@When("^user navigated to my profile section$")
	public void user_navigated_to_my_profile_section() throws Throwable {
		System.out.println("User is on My Profile section");
		Actions a = new Actions(Constants.driver);
		WebElement arrow = Keywords.getWebElement("xpath",
				"//body/div[@id='container']/div/div[@class='_3ybBIU']/div[@class='_1tz-RS']/div[@class='_3pNZKl']/div[3]/div[1]");
		a.moveToElement(arrow).build().perform();
		Thread.sleep(2000);
		WebElement myprofile = Keywords.getWebElement("xpath", "//div[contains(text(),'My Profile')]");
		myprofile.click();
		Log.info("Clicked on My Profile section");
	}

	@When("^User enters data for profile updation$")
	public void user_enters_data_for_profile_updation() throws Throwable {
		Thread.sleep(2000);
		MyProfile mp = new MyProfile(Constants.driver);
		mp.clickonEdit();
		Thread.sleep(1000);
		mp.setFirstName("Abhishek");
		mp.setLastName("Jakhotiya");
		mp.clickOnSaveButton();
	}

	@Then("^User data should get updated$")
	public void user_data_should_get_updated() throws Throwable {
		System.out.println("Data Updated");
	}

}
