package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public static Logger log = LogManager.getLogger(BaseClass.class.getName());

	public static WebDriver driver;

	public Properties prop;

	public void clearCache() {

		try {

			driver.get(prop.getProperty("ClearCacheurl"));
			Thread.sleep(1000);
			driver.switchTo().activeElement();
			driver.findElement(By.cssSelector("* /deep/ #clearBrowsingDataConfirm")).click();
			Thread.sleep(5000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\kbas663\\Maven Projects-Sel\\E2EProject\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\kbas663\\Downloads\\eclips_selenium\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		}

		else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\kbas663\\Downloads\\eclips_selenium\\driver\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();

		}

		else {

			log.fatal("No Such Browser");
		}
		return driver;

	}

	public void screenShot(String name) throws IOException {
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("C:\\Users\\kbas663\\Downloads\\eclips_selenium\\screenshot-sel\\Screenshot-"+name+".png"));
		
		
	}

}
