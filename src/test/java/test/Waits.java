package test;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Waits {
	WebDriver driver;
	@BeforeClass
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test(priority = 1)
	public void withoutWait() {
		driver.get("http://omayo.blogspot.com/");
		driver.manage().window().maximize();
		// this dropdown is lazy one taking 5-8 sec to open options
		driver.findElement(By.xpath("//*[@class=\"dropbtn\"]")).click();
		driver.findElement(By.linkText("Flipkart")).click();
		
	}
	
	
	@Test(priority = 2)
	public void threadSleep() throws InterruptedException {
		driver.get("http://omayo.blogspot.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@class=\"dropbtn\"]")).click();  
		Thread.sleep(10000);
		WebElement flipKartLink = driver.findElement(By.linkText("Flipkart"));
		boolean status = flipKartLink.isDisplayed();
		Assert.assertEquals(true, status);
		driver.findElement(By.linkText("Flipkart")).click();
		
	}
	
	@Test(priority = 3)
	public void implecitlyWait() {
		driver.get("http://omayo.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6)); // DOM polling frequency=500ms
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@class=\"dropbtn\"]")).click();  
		driver.findElement(By.linkText("Flipkart")).click();
		
	}
	
	
	@Test(priority = 4)
	public void explicitlyWait() {
		driver.get("http://omayo.blogspot.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@class=\"dropbtn\"]")).click(); 
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Flipkart"))).click();
		
	}
	
	
	@Test(priority = 5)
	public void fluentWait() {
		driver.get("http://omayo.blogspot.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@class=\"dropbtn\"]")).click(); 
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(200))
				.ignoring(NoSuchElementException.class);
		
		fluentWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Flipkart"))).click();
		
	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
