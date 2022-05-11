package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Elements {

	@Test
	public void elementUsage() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
		options.addArguments("--disable-notification");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		// single element
	
/*		driver.navigate().to("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
		Thread.sleep(3000);
		
		//driver.findElement(By.name("btnK")).click();
		
		// multiple elements
		
		driver.navigate().to("https://trytestingthis.netlify.app/");
		
		List<WebElement> option = driver.findElements(By.id("owc"));
		for (WebElement ele : option) {
			System.out.println(ele.getText());
			
		}
		
		
		// cssSelector
		
		driver.findElement(By.cssSelector("#fname")).sendKeys("Shivansh");
		driver.findElement(By.cssSelector("#lname")).sendKeys("Kumar");
		
	*/
		
		
		// Realtive Locator concept
		driver.navigate().to("https://www.facebook.com/");
		
		WebElement loginButton = driver.findElement(By.name("login"));
		loginButton.getText();
		
		Thread.sleep(3000);
		driver.findElement(RelativeLocator.with(By.linkText("Forgotten password?")).below(loginButton)).click();
		
		
		Thread.sleep(3000);
		driver.quit();
		
		
		
	}
}
