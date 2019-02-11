package Resources;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public WebDriver driver;
	
	public void browserSetup(String browser) {
		if(browser.contains("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium Folder\\chromedriver.exe");
			this.driver = new ChromeDriver();
		}
		if(browser.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium Folder\\geckodriver.exe");
			this.driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}
}
