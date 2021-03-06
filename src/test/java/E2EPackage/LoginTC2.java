package E2EPackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPageObject;
import pageObject.LoginPageObject;

import resources.BaseClass;

public class LoginTC2 extends BaseClass {
	
	
	@BeforeTest
	public void intializer() throws IOException {
				
		driver = initializeDriver();
		log.info("Invoking browser------------------");
	}

	@Test(dataProvider = "loginDataInput")
	public void loginFunction(String user_id, String pwd) throws IOException {

		log.debug("URL is hit on the browser");
		driver.get(prop.getProperty("url"));

		LandingPageObject lanPO = new LandingPageObject(driver);

		LoginPageObject lpo = new LoginPageObject(driver);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		log.debug("No Thanks in clicked");
		lanPO.noThanksButton().click();

		log.debug("Login clicked");
		lanPO.loginButton().click();
		

		lpo.UserIdBox().sendKeys(user_id);
		lpo.pwdBox().sendKeys(pwd);
		lpo.loginButton1().click();
		
	
		//driver.get(prop.getProperty("ChromeClear"));	
		
		clearCache();	
		
		
		
	}

	@AfterTest
	public void tearDown() {

		driver.close();
		driver=null;

	}

	@DataProvider
	public Object[][] loginDataInput() {

		Object[][] data = new Object[2][2];

		data[0][0] = "venkat1793";
		data[0][1] = "venky12345";

		data[1][0] = "kanda12";
		data[1][1] = "kandish1123";

		return data;

	}

}
