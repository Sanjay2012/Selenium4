package test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PopUpsAndAlerts {

	WebDriver driver;

	@Test
	public void alert() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.manage().window().maximize();

		// handle Alert Pop up

		WebElement jsAlert = driver.findElement(By.xpath("//*[@onclick=\"jsAlert()\"]"));
		jsAlert.click();
		Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText());

		// accept
		alert1.accept();
		String result1 = driver.findElement(By.id("result")).getText();
		Assert.assertEquals(result1, "You successfully clicked an alert");

		Thread.sleep(3000);
		driver.quit();

	}

	@Test
	public void confirmationPopUp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.manage().window().maximize();

		// handle confirmation popup

		WebElement jsConfirm = driver.findElement(By.xpath("//*[@onclick=\"jsConfirm()\"]"));
		jsConfirm.click();
		Alert alert2 = driver.switchTo().alert();
		System.out.println(alert2.getText());

		// accept
		alert2.accept();
		String result2 = driver.findElement(By.id("result")).getText();
		Assert.assertEquals(result2, "You clicked: Ok");

		// cancel
		jsConfirm.click();
		alert2.dismiss();
		String result3 = driver.findElement(By.id("result")).getText();
		Assert.assertEquals(result3, "You clicked: Cancel");

		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void confirmationPopUp1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.manage().window().maximize();

		// JS prompt

		// handle confirmation popup

		WebElement jsPrompt = driver.findElement(By.xpath("//*[@onclick=\"jsPrompt()\"]"));
		jsPrompt.click();
		Alert alert4 = driver.switchTo().alert();
		System.out.println(alert4.getText());

		// accept
		alert4.sendKeys("Automation Test");
		alert4.accept();
//				String result4 = driver.findElement(By.id("result")).getText();
//				Assert.assertEquals(result4, "You entered: Automation Test");

		Assert.assertTrue(driver.getPageSource().contains("You entered: Automation Test"));

		// cancel
		jsPrompt.click();
		alert4.dismiss();
		Assert.assertTrue(driver.getPageSource().contains("You entered: null"));

		Thread.sleep(3000);
		driver.quit();

	}

	@Test
	public void childBrowserPopUp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://skpatro.github.io/demo/links/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.manage().window().maximize();

		WebElement newWindowButton = driver.findElement(By.xpath("//*[@name=\"NewWindow\"]"));
		newWindowButton.click();

		Set<String> ids = driver.getWindowHandles();
		int windowCount=ids.size();
		System.out.println(windowCount);
		
		for (String str : ids) {
			driver.switchTo().window(str);
			System.out.println(driver.getTitle());

		}

		// convert set type into list

		ArrayList<String> al = new ArrayList<String>(ids);

		// id of main page
		String idOfMainPage = al.get(0);
		System.out.println("address/id of main page:  " + idOfMainPage);

		// child id
		String idOfChild = al.get(1);
		System.out.println("address/id of child browser page :  " + idOfChild);

		// switch focus to child popup

		driver.switchTo().window(idOfChild);
		Thread.sleep(3000);

		driver.manage().window().maximize();

		// click om home menu

		driver.findElement(By.xpath("//*[text()='HOME']")).click();

		Thread.sleep(3000);

		// Switch to main page
		driver.switchTo().window(idOfMainPage);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@name=\"home\"]")).click();
		driver.quit();
	}
	
	@Test
	public void childBrowserPopUp1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://skpatro.github.io/demo/links/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.manage().window().maximize();

		WebElement newWindowButton = driver.findElement(By.xpath("//*[@name=\"NewWindow\"]"));
		newWindowButton.click();

		Set<String> ids = driver.getWindowHandles();
		int windowCount=ids.size();
		System.out.println(windowCount);
		
		Iterator<String> itr=ids.iterator();
		while (itr.hasNext()) {
			String str =itr.next();
			driver.switchTo().window(str);
			System.out.println(driver.getTitle());
			
		}
			
		}
		
		
	}
	
	
