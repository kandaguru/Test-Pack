package E2EPackage;



import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import resources.BaseClass;

public class URLCheckTC1 extends BaseClass{
	
	
	
	
	
	@Test
	public void Login() throws IOException {
				
		driver=initializeDriver();
		driver.get("http://www.qaclickacademy.com/");
			
	}
	
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver.manage().deleteAllCookies();
	}
	
	
}
