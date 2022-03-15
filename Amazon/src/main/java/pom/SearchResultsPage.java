package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
	
	private Actions actions;
	
	@FindBy(xpath="//div[@data-cel-widget='search_result_2']//h2//a//span")
	private WebElement thirdResult;
	
//	@FindBy(xpath="")
//	private WebElement itemName;
//	
//	@FindBy(xpath="")
//	private WebElement itemDescription;
	
	@FindBy(xpath="(((//div[@data-cel-widget='search_result_2']//div)[1]//div)[25]//a//span)[5]")
	private WebElement itemPrice;

	
	public SearchResultsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	
	public void clickOnThirdResult()
	{
		thirdResult.click();
	}
	
	public void getItemName()
	{
		System.out.println(thirdResult.getText());
	}
	
	public void getItemPrice()
	{
		System.out.println(itemPrice.getText());
	}
}
