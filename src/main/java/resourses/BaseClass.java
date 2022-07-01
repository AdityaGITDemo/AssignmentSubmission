package resourses;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver(Properties prop) throws IOException {
		
		String browserName = prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			// System.setProperty("webdriver.chrome.driver",
			// "D:\\Drivers\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\LatestDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\LatestDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.contains("edge")) {
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "\\LatestDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		return driver;

	}
	
	public Properties propFiles() throws IOException{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\LoginData.properties");
		prop.load(fis);
		return prop;
		
	}

}
