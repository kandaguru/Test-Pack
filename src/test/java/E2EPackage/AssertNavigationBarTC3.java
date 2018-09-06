package E2EPackage;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.LandingPageObject;

import resources.BaseClass;

public class AssertNavigationBarTC3 extends BaseClass {

	@BeforeTest
	public void intitializer() throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

	}

	@Test
	public void assertNavigationBar() throws IOException {

		LandingPageObject lanPO = new LandingPageObject(driver);

		// lanPO.noThanksButton().click();

		Assert.assertTrue(lanPO.navigationBar().isDisplayed());
		log.info("navigation bar present");

	}

	@AfterTest
	public void closeBrowser() {

		driver.close();
		driver = null;

	}

}
