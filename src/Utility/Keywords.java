package Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Keywords {

	public static void applyImplicitWait() {
		Constants.driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}

	public static void openBrowser(String browsername) {
		switch (browsername) {
		case "chrome": {
			System.setProperty("webdriver.chrome.driver", "./Drivers//chromedriver");
			Constants.driver = new ChromeDriver();
			break;
		}
		case "firefox": {
			System.setProperty("webdriver.gecko.driver", "./Drivers//geckodriver");
			Constants.driver = new FirefoxDriver();
			break;
		}
		default:
			System.err.println("Invalid Browser : " + browsername);
		}
	}

	public static void openURL(String url) {
		Constants.driver.get(url);
	}

	/***
	 * returns a WebElement where type should be in form of
	 * xpath,cssSelector,id,linkText,partialLinkText,className (Case Sensitive)
	 * 
	 * @param type  Eg : xpath,cssSelector,id ,linkText,partialLinkText,className
	 * @param value Eg: //div[@class='u_0_3']
	 * @return {@code WebElement } in the form of
	 *         driver.findElement(By.{@code type(@code value )})
	 *
	 */
	public static WebElement getWebElement(String type, String value) {
		switch (type) {
		case "xpath":
			Constants.element = Constants.driver.findElement(By.xpath(value));
			break;
		case "cssSelector":
			Constants.element = Constants.driver.findElement(By.cssSelector(value));
			break;
		case "id":
			Constants.element = Constants.driver.findElement(By.id(value));
			break;
		case "linkText":
			Constants.element = Constants.driver.findElement(By.linkText(value));
			break;
		case "partialLinkText":
			Constants.element = Constants.driver.findElement(By.partialLinkText(value));
			break;
		case "className":
			Constants.element = Constants.driver.findElement(By.className(value));
			break;
		default:
			System.out.println("Invalid Locator type");
			break;

		}
		return Constants.element;
	}

	public static void clickOnWebElement(String type, String value) {
		getWebElement(type, value).click();
	}

	public static void selectValueFromDropDown(String type, String value, int index) {
		WebElement element = getWebElement(type, value);
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public static void closeDriver() {
		Constants.driver.close();
	}

	public static WebElement containsText(String tagname, String textContains) {
		Constants.element = Constants.driver
				.findElement(By.xpath("//" + tagname + "[contains(text(),'" + textContains + "')"));
		return Constants.element;
	}

	public static void applythreaddotsleep(long timeInMS) throws InterruptedException {
		Thread.sleep(timeInMS);
	}

	public static void applyImplicitWait(int timeinSeconds) {
		Constants.driver.manage().timeouts().implicitlyWait(timeinSeconds, TimeUnit.SECONDS);
	}
}
