package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * Hadling dyanamic elemnts
 * ex. books ---> cost
 * ex. Mobile---> reviews
 * 
 * Here  Mobile ---> Independent
 *       Review ---> dependent
 *       
 *       
 *       1. identify dep and inde elemets from scenario
 *       2. find xpath of inde element
 *       3. find common parent between dep and inde element (move up so that both will highlighted)
 *       4. find the xpath of depe element (expand the common parent and move downword directio till depe elem)
 * */

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicElements {
	WebDriver driver;

	@Test
	public void alert() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("Redmi Note 11 Starburst White 128 GB", Keys.ENTER);
		
		WebElement indep = driver.findElement(By.xpath("//*[text()='Redmi Note 11 (Starburst White, 128 GB)']"));
		System.out.println(indep.getText());
		
		 WebElement dep = driver.findElement(By.xpath("//*[text()='Redmi Note 11 (Starburst White, 128 GB)']/..//*[contains(text(),'Reviews')]"));
		
		System.out.println(dep.getText());
		
		Thread.sleep(3000);
		driver.quit();
		
	}

}
