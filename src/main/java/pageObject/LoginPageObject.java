package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject {

	public WebDriver driver;

	By userId = By.cssSelector("input[id='user_email']");
	By pwd = By.cssSelector("input[id='user_password']");
	By loginButton = By.cssSelector("input[type='submit'");

	public LoginPageObject(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement UserIdBox() {
		return driver.findElement(userId);

	}

	public WebElement pwdBox() {
		return driver.findElement(pwd);

	}

	public WebElement loginButton1() {
		return driver.findElement(loginButton);

	}

}
