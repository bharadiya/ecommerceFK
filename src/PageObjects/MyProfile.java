package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import Logger.Log;

public class MyProfile {
	WebDriver driver;

	public MyProfile(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	@FindBy(how = How.XPATH, using = "//span[@class='_1x4IU1']")
	WebElement edit;

	@FindBy(how = How.NAME, using = "firstName")
	WebElement firstName;

	@FindBy(how = How.NAME, using = "lastName")
	WebElement lastName;

	@FindBy(how = How.XPATH, using = "(//button[@type='submit'])[2]")
	WebElement save;
	
//	@FindBy(how=How.XPATH,using="(//input[@type='radio'])[1]")
//	WebElement male;
//	
//	@FindBy(how=How.XPATH,using="(//input[@type='radio'])[2]")
//	WebElement female;
//	
//	@FindBy(how=How.XPATH,using="(//div[@class='_3oYEid'])[1]/a[1]")
//	WebElement editEmailId;
	
	public void clickonEdit() {
		edit.click();
		Log.info("Edit button found");
	}

	public void setFirstName(String fname) {
		firstName.clear();
		firstName.sendKeys(fname);
		Log.info("First name text box found");
	}

	public void setLastName(String lname) {
		lastName.clear();
		lastName.sendKeys(lname);
		Log.info("Last name text box found");
	}

	public void clickOnSaveButton() {
		save.click();
		Log.info("Save button found");
	}

}
