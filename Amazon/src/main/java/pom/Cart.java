package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {
	
	private Actions actions;

	@FindBy(xpath= "//input[@name='proceedToRetailCheckout']")
	private WebElement proccedToBuy;
	
	public Cart(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	
	public void clickOnProceedToBuy()
	{
		proccedToBuy.click();
	}
	
}
