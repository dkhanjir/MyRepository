package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaymentPage {
	
	private Actions actions;
	

	@FindBy(xpath="//input[contains(@value, 'Selectable')]")
	private WebElement addCreditOrDebitOrAtmCardRadioButton;
	
	@FindBy(xpath="//a[contains(text(), 'Add')]")
	private WebElement addCreditOrDebitOrAtmCardLink;
	
	@FindBy(xpath="//input[@name= 'addCreditCardNumber']")
	private WebElement cardNumber;
	
	@FindBy(xpath="//input[contains(@name, 'ppw-a')]")
	private WebElement nameOnCard;

	@FindBy(xpath="//select[@name='ppw-expirationDate_month']")
	private WebElement expiryDateMonth;
	
	@FindBy(xpath="//select[@name='ppw-expirationDate_year']")
	private WebElement expiryDateYear;
	
	@FindBy(xpath="//span[contains(text(),'Use as')]")
	private WebElement useAsMyDefaultPaymentCheckbox;
	
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement cancel;
	
	@FindBy(xpath="//input[@class='a-button-input']")
	private WebElement addYourCard;
	
	@FindBy(xpath="//button[@aria-label='Close']")
	private WebElement closeAddDebitOrCreditCardWindowSymbol;
	
	
	public PaymentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	
	public void clickOnAddCreditOrDebitOrAtmCardRadioButton()
	{
		addCreditOrDebitOrAtmCardRadioButton.click();
	}
	
	public void clickOnAddCreditOrDebitOrAtmCardRadioLink()
	{
		addCreditOrDebitOrAtmCardLink.click();
	}
	
	public void sendCardNumber()
	{
		cardNumber.sendKeys("121456987");
	}
	
	public void sendNameOnCard()
	{
		nameOnCard.clear();
		nameOnCard.sendKeys("Dhananjay Khanjir");
	}
	
	public void selectCardExpirayMonth()
	{
		Select select = new Select(expiryDateMonth);
		select.selectByValue("5");
	}
	
	public void selectCardExpirayYear()
	{
		Select select = new Select(expiryDateYear);
		select.selectByVisibleText("2025");
	}
	
	public void clickOnUseAsMyDefaultPaymentCheckbox()
	{
		useAsMyDefaultPaymentCheckbox.click();
	}
	
	public void clickOnAddyourCard()
	{
		addYourCard.click();
	}
	
	public void clickOnCancel()
	{
		cancel.click();
	}
	
	public void clickOnCloseAddDebitOrCreditCardWindowSymbol()
	{
		closeAddDebitOrCreditCardWindowSymbol.click();
	}
}
