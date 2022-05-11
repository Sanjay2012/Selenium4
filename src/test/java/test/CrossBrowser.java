package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowser {
	WebDriver driver;
	@Parameters("browser")
	@Test
	public void setupApplication(String browser) {
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			Reporter.log("=====Chrome Browser Session Started=====", true);
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			// System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +
			// "//drivers/geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			Reporter.log("=====Firefox Browser Session Started=====", true);
			driver = new FirefoxDriver(options);
		}

		else if (browser.equalsIgnoreCase("edge")) {
			// System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +
			// "//drivers/msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--headless");
			Reporter.log("=====Edge Browser Session Started=====", true);
			driver = new EdgeDriver(options);
		}

		driver.get("https://www.facebook.com/");
		Reporter.log("=====Application Started=====", true);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //
		// deprecated

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		driver.manage().window().maximize();

	}

}
