package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultChildbrowserPage{
	
	private Actions actions;
	
	@FindBy(xpath= "//input[@id='add-to-cart-button']")
	private WebElement addToCart;

	
	public SearchResultChildbrowserPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	
	public void clickOnAddToCart()
	{
		addToCart.click();
	}
}
