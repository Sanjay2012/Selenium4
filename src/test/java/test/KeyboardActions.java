package test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActions {
	WebDriver driver;

	@Test
	public void actionClassSendKeys() throws InterruptedException {

		// Initialize ChromeDriver
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		//options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		//options.setPageLoadStrategy(PageLoadStrategy.NONE);
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		// Navigate to the demo site
		driver.get("https://demoqa.com/text-box");

		// Create object of the Actions class
		Actions actions = new Actions(driver);

		// Enter the Full Name
		WebElement fullName = driver.findElement(By.id("userName"));
		//fullName.sendKeys("Mr.Peter Haynes");
		actions.keyDown(Keys.SHIFT).sendKeys(fullName,"Mr.Peter Haynes" ).keyUp(Keys.SHIFT).sendKeys(Keys.TAB).build().perform();
		Thread.sleep(3000);

		// Enter the Email
		WebElement email = driver.findElement(By.id("userEmail"));
		email.sendKeys("PeterHaynes@toolsqa.com");

		// Enter the Current Address
		WebElement currentAddress = driver.findElement(By.id("currentAddress"));

		currentAddress.sendKeys("43 School Lane London EC71 9GO");

		// Select the Current Address using CTRL + A
	/*	actions.keyDown(Keys.CONTROL);
		actions.sendKeys("a");
		actions.keyUp(Keys.CONTROL);
		actions.build().perform();
	*/	
		actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();

		// Copy the Current Address using CTRL + C
	/*	actions.keyDown(Keys.CONTROL);
		actions.sendKeys("c");
		actions.keyUp(Keys.CONTROL);
		actions.build().perform();
	*/	
		actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();


		// Press the TAB Key to Switch Focus to Permanent Address
	/*	actions.sendKeys(Keys.TAB);
		actions.build().perform();
	*/	
		actions.sendKeys(Keys.TAB).build().perform();

		// Paste the Address in the Permanent Address field using CTRL + V
	/*	actions.keyDown(Keys.CONTROL);
		actions.sendKeys("v");
		actions.keyUp(Keys.CONTROL);
		actions.build().perform();
    */
		actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
		
		// Compare Text of current Address and Permanent Address
		WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
		assertEquals(currentAddress.getAttribute("value"), permanentAddress.getAttribute("value"));

		driver.close();

	}
}
