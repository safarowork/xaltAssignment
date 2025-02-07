package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.Helpers;

public class DashboardPage extends BasePage{

	Helpers helper;
	
	public DashboardPage(WebDriver driver) {
		super(driver);
		helper = new Helpers(driver);
	}
	
	@FindBy(xpath = "//button[text()='Sign Out']")
	private WebElement btn_signOut;
	
	public boolean verifyDashboardPage() {
		return helper.waitForVisibilityOfElement(btn_signOut).isDisplayed();
	}
	
	public void clickSignOut() {
		helper.waitForVisibilityOfElement(btn_signOut).click();
	}

}
