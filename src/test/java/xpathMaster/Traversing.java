package xpathMaster;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Traversing {
	static WebDriver driver;
	ChromeOptions options;
	JavascriptExecutor js = (JavascriptExecutor)driver;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		options = new ChromeOptions();
		options.addArguments("--disable-notification");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@Test(enabled = false)
	public void xpathStrategy() {
		
		driver.get("https://www.makemytrip.com/flight/search?itinerary=DEL-BLR-25/04/2022&tripType=O&paxType=A-1_C-0_I-0&intl=false&cabinClass=E&ccde=IN&lang=eng");

		// click on search button

	/*	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10, 1));
    	WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()= 'Search']")));

		WebElement searchButton = driver.findElement(By.xpath("//a[text()= 'Search']"));
		 WebElement searchButton1 =
		 driver.findElement(By.cssSelector(".primaryBtn.font24.latoBold.widgetSearchBtn"));
		js.executeScript("arguments[0].scrollIntoView();",searchBtn);
		searchBtn.click();
		
		js.executeScript("arguments[0].click();", searchBtn);
	*/
		// get the prize of the spiceJet flight

		WebElement prize = driver.findElement(By.xpath(
				"//*[@id=\"flight_list_item_4_RKEY:a06e8eea-fd24-4ac6-9763-f8adf77e7080:21_0\"]//p[@class=\"blackText fontSize18 blackFont white-space-no-wrap\"]"));
		
		System.out.println("departure time of spiceJet is  :" + prize.getText());
		
		
		/* indiGo prize
		 * 
		 * //*[@id="flight_list_item_51_RKEY:e035b07c-32f8-4105-900a-baf03f0fefda:50_0"]//p[@class="blackText fontSize18 blackFont white-space-no-wrap"]
		 * 
		 * */

	}
	
	
	@Test
	public void getCovidCount() {
		driver.get("https://www.covid19india.org/");
		
		/*Kerala active patients
		 * //*[text()='Kerala']/../following-sibling::div[2]/child::div[@class="total"]
		 * 
		 * //*[text()='Kerala']/../..//div[3]/div[@class='total']
		 * 
		 * */
		
	WebElement keralaActive = driver.findElement(By.xpath("//*[text()='Kerala']/../following-sibling::div[2]/child::div[@class=\"total\"]"));
		System.out.println(keralaActive.getText());
		
		
	}
	
	@Test
	public void flipKartReviews() {
		
		driver.get("https://www.flipkart.com/");
		
		WebElement serachMI = driver.findElement(By.name("q"));
		serachMI.sendKeys("mi 11i",Keys.ENTER);
		
		WebElement review = driver.findElement(By.xpath("//*[text()='REDMI NOTE 10 LITE (Aurora Blue, 128 GB)']/parent::div//span[@class=\"_2_R_DZ\"]/child::span//span[3]"));
		System.out.println(review.getText());
		
		
		WebElement prize = driver.findElement(By.xpath("//*[text()='REDMI NOTE 10 LITE (Aurora Blue, 128 GB)']/../..//div[@class=\"col col-5-12 nlI3QM\"]//div[@class=\"_30jeq3 _1_WHN1\"]"));
		System.out.println(prize.getText());
	
	}

	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
