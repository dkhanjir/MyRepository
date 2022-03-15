package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	
	private Actions actions;
	
	@FindBy(xpath="//input[@id='ap_email']")
	private WebElement emailOrMobilePhoneNumber;
	
	@FindBy(xpath="//input[@id='continue']")
	private WebElement continueToSignIn;
	
	@FindBy(xpath="//input[@id='ap_password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	private WebElement finalSignIn;
	
	

	public SignInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	
	public void sendEmailOrMobileNumber(String username)
	{
		emailOrMobilePhoneNumber.sendKeys(username);
	}
	
	public void clickOnContinue()
	{
		continueToSignIn.click();
	}
	
	public void sendPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickOnFinalSignIn()
	{
		finalSignIn.click();
	}
	
	

}
