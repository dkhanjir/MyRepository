package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPay{
	
	private Actions actions;
	
	@FindBy(xpath="//span[text()='Mobile Recharge']")
	private WebElement mobileRecharge;
	
	@FindBy(xpath="//span[text()='Mobile Recharge']")
	private WebElement helpMePlease;
	
	public AmazonPay(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	
	public void clickOnMobileRecharge()
	{
		mobileRecharge.click();
	}
	

	
	

}
