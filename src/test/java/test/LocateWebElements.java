package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocateWebElements {
	WebDriver driver;

	@Test
	public void findElement() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Selenium" + Keys.ENTER);

//		searchBox.sendKeys("Selenium");
//		driver.findElement(By.name("btnK")).click();

		driver.quit();

	}

	@Test
	public void findElements() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://trytestingthis.netlify.app/");

		// List<WebElement> option = driver.findElements(By.name("Optionwithcheck[]"));
		List<WebElement> option = driver.findElements(By.tagName("select"));

		for (WebElement ele : option) {
			System.out.println(ele.getText());
		}
		driver.quit();

	}

	@Test
	public void elementWithinElement() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		WebElement form = driver.findElement(By.tagName("form"));
		form.findElement(By.name("q")).sendKeys("Selenium" + Keys.ENTER);

		driver.quit();

	}
	
	
	@Test
	public void getActiveElement() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		
		// get attribute of current element
		String attr = driver.switchTo().activeElement().getAttribute("title");
		System.out.println(attr);
		driver.quit();

	}
	
	
	@Test
	public void getElementsAttribute() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		WebElement searchBox = driver.findElement(By.name("q"));
		System.out.println(searchBox.getTagName());
		System.out.println(searchBox.getText());
		System.out.println(searchBox.getAttribute("style"));
		System.out.println(searchBox.getCssValue("font"));
		System.out.println(searchBox.getCssValue("font-size"));
		System.out.println(searchBox.getCssValue("background-color"));
		System.out.println(searchBox.getCssValue("color"));
		driver.quit();

	}
	
	
	@Test
	public void isSelected() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		WebElement checkBox1 = driver.findElement(By.xpath("//*[@type=\"checkbox\"]"));
		WebElement checkBox2 = driver.findElement(By.xpath("(//*[@type=\"checkbox\"])[2]"));
		System.out.println(checkBox1.isEnabled());
		System.out.println(checkBox1.isSelected());
		System.out.println(checkBox1.isDisplayed());
		
		System.out.println(checkBox2.isEnabled());
		System.out.println(checkBox2.isSelected());
		System.out.println(checkBox2.isDisplayed());

		driver.quit();

	}

}
