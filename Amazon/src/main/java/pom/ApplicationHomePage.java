package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationHomePage {
	
	private Actions actions;
	
	@FindBy(xpath= "(//span[text()='Sign in'])[1]")
	private WebElement signIn;
	
	@FindBy(xpath= "//span[text()='Sign Out']")
	private WebElement signOut;
	
	

	public ApplicationHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	
	public void clickOnSignIn()
	{
		signIn.click();
	}
	
	public void clickOnSignOut()
	{
		signOut.click();
	}

}
