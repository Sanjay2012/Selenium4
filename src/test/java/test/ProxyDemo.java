package test;

import java.time.Duration;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProxyDemo {

	public static void main(String[] args) {
		Proxy proxy=new Proxy();
		proxy.setAutodetect(false);
		//proxy.setHttpProxy("localhost:8080");
		proxy.setSslProxy("localhost:8080");
		
		FirefoxOptions options=new FirefoxOptions();
		options.setCapability("proxy", proxy);
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver(options);
		
		driver.navigate().to("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.manage().window().maximize();
		
		driver.quit();
		

	}

}
