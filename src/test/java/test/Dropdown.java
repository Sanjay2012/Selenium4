package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {
	WebDriver driver;

	@Test
	public void selectDropdownOptions() throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		// Navigate to the demo site
		driver.get("https://trytestingthis.netlify.app/");

		WebElement dropdown = driver.findElement(By.id("option"));
		Select option = new Select(dropdown);

		option.selectByIndex(1);
		Thread.sleep(2000);
		option.selectByValue("option 2");
		Thread.sleep(2000);
		option.selectByVisibleText("Option 3");
		Thread.sleep(2000);
		
		driver.quit();
		System.out.println("done");

	}
	
	
	@Test
	public void dropdownOptions() throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		// Navigate to the demo site
		driver.get("https://trytestingthis.netlify.app/");

		WebElement dropdown = driver.findElement(By.id("option"));
		Select options = new Select(dropdown);
		
		List<WebElement> allOptions = options.getOptions();
		for (WebElement option : allOptions) {
			System.out.println(option.getText());
			
			if (option.getText().equalsIgnoreCase("option 2")) {
				option.click();
				
			}
			Thread.sleep(3000);
			
		}
		driver.quit();
}
	
	
	@Test
	public void multiSelect() throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		// Navigate to the demo site
		driver.get("https://trytestingthis.netlify.app/");

		WebElement dropdown = driver.findElement(By.id("owc"));
		Select option = new Select(dropdown);
		option.selectByIndex(1);
		Thread.sleep(2000);
		option.selectByValue("option 2");
		Thread.sleep(2000);
		option.selectByVisibleText("Option 3");
		Thread.sleep(2000);
		option.deselectByVisibleText("Option 3");
		Thread.sleep(2000);
		option.getAllSelectedOptions();
		Thread.sleep(2000);
		option.getFirstSelectedOption();
		Thread.sleep(2000);
		option.selectByVisibleText("Option 3");
		Thread.sleep(2000);
		option.getFirstSelectedOption();
		Thread.sleep(2000);
		option.getAllSelectedOptions();
		Thread.sleep(2000);
		
		
		driver.quit();
		System.out.println("done");

	}
}
