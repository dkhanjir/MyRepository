package pom;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class ApplicationHeaderPage {
	
	private Actions actions;
	
	@FindBy(xpath = "//span[@class='icp-nav-link-inner']")
	private WebElement language;
	
	@FindBy(xpath = "//a[@id='nav-link-accountList']")
	private WebElement signInAndAccountAndList;
	
	@FindBy(xpath = "//a[@id='nav-orders']")
	private WebElement returnsAndOrders;
	
	@FindBy(xpath = "(//span[@class='nav-line-2'])[3]")
	private WebElement cart;
	
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement searchBox;
	
	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//a[text()='Amazon Pay']")
	private WebElement amazonPay;
	
	public ApplicationHeaderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	
	public void moveToSignInAndAccountAndList()
	{
		actions.moveToElement(signInAndAccountAndList).perform();
	}
	
	public void moveToLanguage()
	{
		actions.moveToElement(language).perform();
	}
	
	public void clickOnCart()
	{
		cart.click();
	}
	
	public void clickOnRetunsAndOrders()
	{
		returnsAndOrders.click();
	}
	
	public void enterItemToSearch(String item)
	{
		searchBox.sendKeys(item);
	}
	
	public void clickOnSearchButton()
	{
		searchButton.click();
	}
	
	public void clickOnAmazonPay()
	{
		amazonPay.click();
	}
}
