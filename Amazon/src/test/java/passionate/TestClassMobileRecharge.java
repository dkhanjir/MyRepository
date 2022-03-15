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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Browser;
import pom.AmazonPay;
import pom.ApplicationHeaderPage;
import pom.ApplicationHomePage;
import pom.MobileRechargePage;
import pom.SignInPage;
import utils.Utility;

public class TestClassMobileRecharge extends Browser {
	
	private WebDriver driver;
	private ApplicationHeaderPage applicationHeaderPage;
	private ApplicationHomePage applicationHomePage;
	private SignInPage signInPage;
	private AmazonPay amazonPay;
	private MobileRechargePage mobileRechargePage;
    private SoftAssert softAssert;
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
	public void launchTheBrowser()
	{
		
		applicationHeaderPage  = new ApplicationHeaderPage(driver);
		applicationHomePage  = new ApplicationHomePage(driver);
		amazonPay = new AmazonPay(driver);
		mobileRechargePage = new MobileRechargePage(driver);	
	}
	
	@BeforeMethod
	public void loginToTheApplication() throws InterruptedException, EncryptedDocumentException, IOException
	{
		driver.get("https://www.amazon.in/");
		
		
		applicationHeaderPage.moveToSignInAndAccountAndList();
		
		//Thread.sleep(5000);//for gecko
		
		applicationHomePage.clickOnSignIn();
		
        signInPage  = new SignInPage(driver);
        
        String username = Utility.getData("credentials",1,1);
 	    String password = Utility.getData("credentials",1,2);
		
		signInPage.sendEmailOrMobileNumber(username);
		signInPage.clickOnContinue();
		signInPage.sendPassword(password);
		signInPage.clickOnFinalSignIn();
		
		applicationHeaderPage.clickOnAmazonPay();
		amazonPay.clickOnMobileRecharge();
		//softAssert= new SoftAssert();
		
	}

	@Test
	public void verifyMobileRechareButton()//by default priority will be 0.
	{
		testID = "MR101";
		
		softAssert= new SoftAssert();//For every method which has soft assert in it first line of it must be this line.
		                            // For every method which has soft assert new object of SoftAssert has to be created
		                            // so we can write this line in before method as well but it is more appropriate in test method
		 
		System.out.println("VerifyMobileRechareButton");
	
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		Assert.assertEquals(url, "https://www.amazon.in/hfc/mobileRecharge?ref_=apay_deskhome_MobileRecharge");
		boolean result = title.equals("Prepaid Recharges");
		Assert.assertTrue(result);
		
	    result = mobileRechargePage.verifyVisibilityOfEditOperatorAndCircleButton();
//	    SoftAssert softAssert = new SoftAssert();
	    softAssert.assertEquals(result,false,"Edit operator and circle button is visible");//String message will be printed on he console 
	                                                                                     // only when condition fails.
	   
	    
	    mobileRechargePage.sendMobileNumber();
	    result = mobileRechargePage.verifyVisibilityOfEditOperatorAndCircleButton();
	    softAssert.assertTrue(result);
	    softAssert.assertAll();//For every method which has soft assert in it last line of it must be this line.
		
	}


	
	@Test(priority=2)
	public void verifyPayButton() throws InterruptedException
	{
		testID = "MR102";
		
		System.out.println("VerifyPayButton");
		
		mobileRechargePage.sendMobileNumber();
		mobileRechargePage.clickOnOperatorAndCircle();
		
		Thread.sleep(3000);
	
		mobileRechargePage.clickOnOpearorAirtel();
		
		mobileRechargePage.clickOnCircleMaharashtraAndGoa();
		//Thread.sleep(7000);////for gecko
		mobileRechargePage.sendRechargeAmount();
		mobileRechargePage.clickOnPay();
		
		Thread.sleep(5000);
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		driver.navigate().back();
		driver.navigate().back();
		

		System.out.println(url);
		System.out.println(title);
		
		 Assert.assertEquals(url,"https://www.amazon.in/gp/buy/payselect/handlers/display.html?hasWorkingJavascript=1");
		 Assert.assertEquals(title,"Select a Payment Method - Amazon.in Checkout");
		
	}
	
	
	@AfterMethod
	public void logoutFromTheApplication() throws InterruptedException, IOException
	{
		Utility.captureScreenshot(driver,testID);
		//softAssert.assertAll();//don't write here even if it is common line in multiple methods
		applicationHeaderPage.moveToSignInAndAccountAndList();
		//Thread.sleep(7000);//for gecko
		applicationHomePage.clickOnSignOut();
		
	}

	@AfterClass
	public void clearPOMClassObjectReferences() 
	{
		applicationHeaderPage = null;
		applicationHomePage = null;
		amazonPay = null;
		mobileRechargePage = null;
	}
	

	@AfterTest
	public void closeTheBrowser()
	{	
		driver.quit();
		driver= null;
		System.gc();
	}


}
