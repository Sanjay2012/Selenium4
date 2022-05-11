package test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserActions {

	@Test
	public void browserAction() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		// WebDriverManager.chromedriver().driverVersion("92.0").setup();
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
		options.addArguments("--disable-notification");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		
		// BROWSER ACTIONS
		
	/*	driver.get("https://www.facebook.com/");
		String originalWindow=driver.getWindowHandle();
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		driver.navigate().to("https://www.selenium.dev/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();
		
		// HANDLING WINDOWS
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().window(originalWindow);
		*/
		
		//HANDLING IFRAMES
	/*	
		driver.navigate().to("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.className("interfaceName")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent(); // switch to main frame
	*/
		
		
		// WINDOW MANAGEMENT-SIZE
		
		driver.get("https://www.facebook.com/");
		
		// get size
		
	/*	int width=driver.manage().window().getSize().getWidth();
		int height=driver.manage().window().getSize().getHeight();
		
		Dimension size = driver.manage().window().getSize();
		System.out.println(size.getHeight());
		System.out.println(size.getWidth());
		
		
		//set size
		driver.manage().window().setSize(new Dimension(600, 800) );
	*/
		
		
		// get position
		
	/*	Point position = driver.manage().window().getPosition();
		System.out.println(position.getX());
		System.out.println(position.getY());
		
		 // set position
		
		driver.manage().window().setPosition(new Point(800, 600));
		
	*/
		
		
		// maximize, minimize and full screen
		
	/*	driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.manage().window().minimize();
		Thread.sleep(2000);
		
		driver.manage().window().fullscreen();
		
	*/
		
		// TAKE a Screenshots
		
	/*	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		File destFile=new File("./Screenshots/test.png");
		//FileHandler.copy(scrFile, destFile);
		FileUtils.copyFile(scrFile, destFile);
		
		
		WebElement element = driver.findElement(By.xpath("//img[@alt='Facebook']"));
		File scrFile1 = element.getScreenshotAs(OutputType.FILE); 
		File destFile1=new File("./Screenshots/test1.png");
		FileHandler.copy(scrFile1, destFile1);
		
	*/
		
		
		//JAVASCRIPT
		
		JavascriptExecutor js=(JavascriptExecutor)driver; // js typecast into driver
		
		
		// getting innert text
		WebElement button = driver.findElement(By.xpath("//*[@name=\"login\"]"));
		//String text=(String) js.executeScript("return arguments[0].innerText", button);
		String text=(String) js.executeScript("return arguments[0].value", button);
		System.out.println(text);
		Thread.sleep(2000);
		
		
		// click on button
		 js.executeScript("arguments[0].click();", button);
		//js.executeScript("document.getElementById('u_0_d_W/').click();");
		Thread.sleep(2000);
		
		// enter text into text field
		
		WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		
		js.executeScript("arguments[0].value='Sanjay@in.in';", email);
		
		Thread.sleep(2000);
		
		//scroll down page
		
		WebElement link = driver.findElement(By.linkText("Facebook Lite"));
		js.executeScript("arguments[0].scrollIntoView();", link);
	
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

}
