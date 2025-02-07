package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h1[text()='Open Capital Network']")
	private WebElement txt_display;
	
	@FindBy(xpath = "//button[text()='Get Started']")
	private WebElement btn_getStarted;
	
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement link_signIn;
	
	public boolean verifyHomePage() {
		return txt_display.isDisplayed();
	}
	
	public void clickGetStarted() {
		btn_getStarted.click();
	}
	
	public void clickSignin() {
		link_signIn.click();
	}

}
