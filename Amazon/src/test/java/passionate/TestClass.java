package passionate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.AmazonPay;
import pom.ApplicationHeaderPage;
import pom.ApplicationHomePage;
import pom.Cart;
import pom.MobileRechargePage;
import pom.PaymentPage;
import pom.SearchResultChildbrowserPage;
import pom.SearchResultsPage;

import pom.SignInPage;
import utils.Utility;

public class TestClass {
	public static void main(String[]args) throws InterruptedException, EncryptedDocumentException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Software Testing\\Chrome\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		ApplicationHeaderPage applicationHeaderPage  = new ApplicationHeaderPage(driver);
		
		applicationHeaderPage.moveToSignInAndAccountAndList();
		
		ApplicationHomePage applicationHomePage  = new ApplicationHomePage(driver);
		applicationHomePage.clickOnSignIn();

		SignInPage signInPage  = new SignInPage(driver);
		
		String username = Utility.getData("credentials",1,1);
		String password = Utility.getData("credentials",1,2);
			
		signInPage.sendEmailOrMobileNumber(username);
		signInPage.clickOnContinue();
		signInPage.sendPassword(password);
		signInPage.clickOnFinalSignIn();
		
		applicationHeaderPage.enterItemToSearch("HP Laptops");
		applicationHeaderPage.clickOnSearchButton();
		
		SearchResultsPage SearchResultsPage = new SearchResultsPage(driver);
		SearchResultsPage.getItemName();
		SearchResultsPage.getItemPrice();
		SearchResultsPage.clickOnThirdResult();
		
		
		ArrayList<String> arraylist = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(arraylist.get(1));
		
		SearchResultChildbrowserPage serachResultChildbrowserPage = new SearchResultChildbrowserPage(driver);
		serachResultChildbrowserPage.clickOnAddToCart();
		
		Thread.sleep(3000);
		
		driver.close();
		
		driver.switchTo().window(arraylist.get(0));
		
		applicationHeaderPage.clickOnCart();
		
		Cart cart = new Cart(driver);
		
		cart.clickOnProceedToBuy();
		
//		signInPage.sendPassword();
//		signInPage.clickOnFinalSignIn();
		
		driver.navigate().back();
		
		applicationHeaderPage.clickOnAmazonPay();
		
		AmazonPay amazonPay = new AmazonPay(driver);
		
		amazonPay.clickOnMobileRecharge();
		
		MobileRechargePage mobileRechargePage= new MobileRechargePage(driver);
		
		mobileRechargePage.sendMobileNumber();
		mobileRechargePage.clickOnOperatorAndCircle();
		Thread.sleep(3000);
		mobileRechargePage.clickOnOpearorAirtel();
		Thread.sleep(2000);
		mobileRechargePage.clickOnCircleMaharashtraAndGoa();
		mobileRechargePage.sendRechargeAmount();
		mobileRechargePage.clickOnPay();
		
//		signInPage.sendPassword();
//		signInPage.clickOnFinalSignIn();
		
		
		PaymentPage paymentPage= new PaymentPage(driver);
		paymentPage.clickOnAddCreditOrDebitOrAtmCardRadioButton();
		paymentPage.clickOnAddCreditOrDebitOrAtmCardRadioLink();
		
		driver.switchTo().frame("ApxSecureIframe");
		paymentPage.sendCardNumber();
		paymentPage.sendNameOnCard();
		paymentPage.selectCardExpirayMonth();
		paymentPage.selectCardExpirayYear();
		paymentPage.clickOnAddyourCard();
		
		
		paymentPage.clickOnCloseAddDebitOrCreditCardWindowSymbol();
		
	
		driver.navigate().back();
		driver.navigate().back();
		
		applicationHeaderPage.moveToSignInAndAccountAndList();
		
	
		
		applicationHomePage.clickOnSignOut();
		
		
		
	}
	

}
