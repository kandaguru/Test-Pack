package E2EPackage;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import resources.BaseClass;

public class URLCheckTC1 extends BaseClass{
	
	
	
	
	
	@Test
	public void Login() throws IOException {
				
		driver=initializeDriver();
		driver.get("http://www.qaclickacademy.com/");
		
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("url"));
			
	}
	
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver=null;
		
	}
	
	
}
