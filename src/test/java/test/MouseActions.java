package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActions {
	WebDriver driver;

	@Test
	public void clickAndHold() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		// Navigate to the demo site
		driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
		
		WebElement boxA = driver.findElement(By.name("A"));
		WebElement boxL = driver.findElement(By.name("L"));
		
		Actions act=new Actions(driver);
		
		//act.moveToElement(boxA).clickAndHold().moveToElement(boxL).release().perform();
		act.dragAndDrop(boxA, boxL).perform();
		Thread.sleep(10000);
		driver.quit();

	}
}
