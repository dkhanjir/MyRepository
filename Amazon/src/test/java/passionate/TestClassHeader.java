package passionate;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Browser;
import pom.ApplicationHeaderPage;
import pom.ApplicationHomePage;
import pom.SignInPage;
import utils.Utility;

public class TestClassHeader extends Browser {
	
	private WebDriver driver;
	private ApplicationHeaderPage applicationHeaderPage;
	private ApplicationHomePage applicationHomePage;
	private SignInPage signInPage;
	private String testID;
	
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@BeforeTest
	@Parameters("browser")	
	public void lauchBrowser(String browserName)
	{
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		if(browserName.equals("Chrome"))
		 {
			driver= launchChromeBrowser();
		   
		 }
		if(browserName.equals("Firefox"))
		 {
			driver= launchFirefoxBrowser();
	
		 }
		if(browserName.equals("Edge"))
		 {
			driver= launchEdgeBrowser();
		
		 }
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    
	}
	
	
	
	@BeforeClass
	public void createObjectOfPOMClasses()
	{
		applicationHeaderPage  = new ApplicationHeaderPage(driver);
		applicationHomePage  = new ApplicationHomePage(driver);
		signInPage  = new SignInPage(driver);
	}
	
	@BeforeMethod
	public void signInToApplication() throws InterruptedException, EncryptedDocumentException, IOException
	{
		driver.get("https://www.amazon.in/");
        
		
		applicationHeaderPage.moveToSignInAndAccountAndList();
		
		//Thread.sleep(3000);//for gecko
		
		
		applicationHomePage.clickOnSignIn();

	   String username = Utility.getData("credentials",1,1);
	   String password = Utility.getData("credentials",1,2);
		
		signInPage.sendEmailOrMobileNumber(username);
		signInPage.clickOnContinue();
		signInPage.sendPassword(password);
		signInPage.clickOnFinalSignIn();
	}
	
	@Test
	public void verifyRetrunsAndOrdersTab()
	{
		 testID = "H101";
		 applicationHeaderPage.clickOnRetunsAndOrders();
		 String url= driver.getCurrentUrl();
		 String title= driver.getTitle();
		 
//		 if(url.equals("https://www.amazon.in/gp/css/order-history?ref_=nav_orders_first"))
//		 {
//			 System.out.println("Pass");
//		 }
//		 else
//		 {
//			 System.out.println("Fail");
//		 }
//		 
//		 if(title.equals("Your Orders"))
//		 {
//			 System.out.println("Pass");
//		 }
//		 else
//		 {
//			 System.out.println("Fail");
//		 }
		 
		 Assert.assertEquals(url, "https://www.amazon.in/gp/css/order-history?ref_=nav_orders_first");
		 Assert.assertEquals(title,"Your Orders");
		 
	}
	
	@Test
	public void verifyCartTab()
	{
		
		 testID = "H102";
		 applicationHeaderPage.clickOnCart();
		 String url= driver.getCurrentUrl();
		 String title= driver.getTitle();
		 
//		 if(url.equals("https://www.amazon.in/gp/cart/view.html?ref_=nav_cart"))
//		 {
//			 System.out.println("Pass");
//		 }
//		 else
//		 {
//			 System.out.println("Fail");
//		 }
//		 
//		 if(title.equals("Amazon.in Shopping Cart"))
//		 {
//			 System.out.println("Pass");
//		 }
//		 else
//		 {
//			 System.out.println("Fail");
//		 }
		 
		 
		 Assert.assertNotEquals(url,"https://www.amazon.in/");
		 Assert.assertEquals(title,"Amazon.in Shopping Cart");
		 //Assert.fail();
		 
		 System.out.println("VerifyCartButton");
	}
	

//	@Test
//	public void verifyLanguageTab()
//	{
//		 applicationHeaderPage.moveToLanguage();
//	}
//	

	@Test
	public void verifyAmazonPayTab()
	{
		 testID = "H103";
		 applicationHeaderPage.clickOnAmazonPay();
		 String url= driver.getCurrentUrl();
		 String title= driver.getTitle();
		 
//		 if(url.equals("https://www.amazon.in/gp/sva/dashboard?ref_=nav_cs_apay"))
//		 {
//			 System.out.println("Pass");
//		 }
//		 else
//		 {
//			 System.out.println("Fail");
//		 }
//		 
//		 if(title.equals("Amazon Pay"))
//		 {
//			 System.out.println("Pass");
//		 }
//		 else
//		 {
//			 System.out.println("Fail");
//		 }
		 boolean result = url.equals("https://www.amazon.in/gp/sva/dashboard?ref_=nav_cs_apay");
		 Assert.assertTrue(result);
		 Assert.assertTrue(title.equals("Amazon Pay"));
		 //Assert.assertFalse(title.equals("Your Orders"));
		 System.out.println("VerifyAmazonPayButton");
	}
	
	
	@AfterMethod
	public void logoutFromApplication() throws InterruptedException, IOException
	{
		 Utility.captureScreenshot(driver,testID);
		 applicationHeaderPage.moveToSignInAndAccountAndList();
		 //Thread.sleep(7000);//for gecko
		 applicationHomePage.clickOnSignOut();
	}

	
	@AfterClass
	public void clearPOMClassObjectReferences()
	{
		applicationHeaderPage  = null;
		applicationHomePage  =  null;
		signInPage  = null;
		
	}
	
	
	@AfterTest
	public void closeTheBrowser() throws InterruptedException
	{
		
		driver.quit();
		driver= null;
		System.gc();
	}

}
