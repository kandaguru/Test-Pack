package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPageObject {
	
	public WebDriver driver;

	By login=By.xpath("//i[@class='fa fa-lock fa-lg']/following-sibling::span");
	By noThanks=By.xpath("//button[contains(text(),'NO THANKS')]");
	By navigationBar=By.cssSelector("ul[class='nav navbar-nav navbar-right']");
	
	
	public LandingPageObject(WebDriver driver) {
		
		this.driver=driver;
	}
	
	
	public WebElement noThanksButton() {
		
		return driver.findElement(noThanks);
		
	}
	
	
	public WebElement loginButton() {
		
		return driver.findElement(login);
	}
	
	

public WebElement navigationBar() {
		
		return driver.findElement(navigationBar);
	}
	
	
	
	
		
	}




