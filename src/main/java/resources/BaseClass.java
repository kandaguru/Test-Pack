package resources;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public static Logger log = LogManager.getLogger(BaseClass.class.getName());

	public  WebDriver driver;

	public Properties prop;

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

			driver = new FirefoxDriver();

		}

		else {

			log.fatal("No Such Browser");
		}
		return driver;

	}

}
