
package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import Logger.Log;

public class Login {
	WebDriver driver;

	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	@FindBy(how = How.XPATH, using = "(//input[@type='text'])[2]")
	WebElement username;
	
	@FindBy(how = How.XPATH, using = "//input[@type='password']")
	WebElement password;
	
	@FindBy(how = How.XPATH, using = "(//button[@type='submit'])[2]")
	WebElement click;

	public void setUsername(String uname) {
		username.sendKeys(uname);
		Log.info("Enter Username webelement found");
	}

	public void setPassword(String pass) {
		password.sendKeys(pass);
		Log.info("Enter Password webelement found");
	}

	public void clickLogInButton() {
		click.click();
		Log.info("Login Button found");
	}

}
