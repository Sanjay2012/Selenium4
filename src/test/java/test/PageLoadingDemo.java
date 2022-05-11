package test;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageLoadingDemo {
	
	ChromeOptions options;
	WebDriver driver;
	String url="https://www.facebook.com/";
	
	@BeforeClass
	public void setUp() {
	options=new ChromeOptions();
	
	}
	
	@Test(priority = 1)
	public  void normalPageLoad() {
		
		/* Normal page load strategy
		 * - wait for entire page to be loaded
		 * - SE webdriver waits until the load event fire is return  
		 * - bydefalt Normal load page strategy used if not specified*/
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(options);
		
		driver.navigate().to(url);
	}
	
	@Test(priority = 2)
	public  void eagerPageLoad() {
		
		/* Eager page load strategy
		 * - wait until the initial HTML document has been completely loaded and parsed
		 * - discards stylesheets, images and frames
		 * - SE webdriver waits until the DOMContentsLoaded load event fire is return */
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(options);
		
		driver.navigate().to(url);
	}
	
	
	@Test(priority = 3)
	public  void nonePageLoad() {
		
		/* None page load strategy
		 * - SE webdriver waits until the initial page is loaded */
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(options);
		
		driver.navigate().to(url);
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
		
	}

}
