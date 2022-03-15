package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	

	public static WebDriver launchChromeBrowser() 
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Software Testing\\Chrome\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    return driver;
	}
	
	public static WebDriver launchFirefoxBrowser() 
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Software Testing\\firefox\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	
	public static WebDriver launchEdgeBrowser() 
	{
		System.setProperty("webdriver.edge.driver", "F:\\Software Testing\\edge\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		return driver;
	}
}
