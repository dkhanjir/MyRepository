package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileRechargePage {
	
	private Actions actions;
	
	@FindBy(xpath="//input[@name='phoneNumber']")
	private WebElement mobilePhoneNumber;
	
	@FindBy(xpath="//a[@id='operatorCircleLink']")
	private WebElement editOperatorAndCircleButton;
	
	@FindBy(xpath="//input[@id='operatorAndCircleTextInputId']")
	private WebElement operatorAndCircle;
	
	@FindBy(xpath="//span[text()='Airtel']")
	private WebElement operatorAirtel;
	
	@FindBy(xpath="//span[text()='Maharashtra & Goa']")
	private WebElement circleMaharashtraAndGoa;
	
	@FindBy(xpath="//input[@name='rechargePlan']")
	private WebElement rechargeAmount;
	
	@FindBy(xpath="//button[@id='buyButtonNative']")
	private WebElement pay;
	
	public MobileRechargePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	
	public void sendMobileNumber()
	{
		mobilePhoneNumber.sendKeys("8805809835");
	}
	
	public void clickOnOperatorAndCircle()
	{
		operatorAndCircle.click();
	}
	
	public boolean verifyVisibilityOfEditOperatorAndCircleButton()
	{
		boolean result = editOperatorAndCircleButton.isDisplayed();
		return result;
	}
	
	public void clickOnEditOperatorAndCircleButton()
	{
		editOperatorAndCircleButton.click();
	}
	
	public void clickOnOpearorAirtel()
	{
		operatorAirtel.click();
	}
	
	public void clickOnCircleMaharashtraAndGoa()
	{
		circleMaharashtraAndGoa.click();
	}
	
	public void sendRechargeAmount()
	{
		rechargeAmount.sendKeys("549");
	}

	public void clickOnPay()
	{
		pay.click();
	}
	
	

}
