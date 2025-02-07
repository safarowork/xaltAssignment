package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.Helpers;

public class SignInPage extends BasePage {

	public SignInPage(WebDriver driver) {
		super(driver);
		helper = new Helpers(driver);
	}
	
	Helpers helper;
	
	@FindBy(xpath = "//button[contains(text(),'sign up')]")
	private WebElement link_signUp;
	
	@FindBy(xpath = "//label[text()='E-Mail']//parent::div//descendant::input")
	private WebElement txt_email;
		
	@FindBy(xpath = "//label[text()='Password']//parent::div//descendant::input")
	private WebElement txt_password;
	
	@FindBy(xpath = "//button[text()='Forgot Password']")
	private WebElement link_forgotPassword;
		
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement btn_signIn;
	
	
	public boolean verifySignInPage() {
		return helper.waitForVisibilityOfElement(link_signUp).isDisplayed();
	}
	
	public void enterSigninEmail(String email) {
		txt_email.sendKeys(email);
	}
	
	public void enterSigninPassword(String password) {
		txt_password.sendKeys(password);
	}
	
	public void clickSignIn() {
		helper.javaScriptClick(btn_signIn);
	}
	
	public boolean signInBtnVisibility() {
		return btn_signIn.isEnabled();
	}
	
	public boolean verifyForgotPasswordLink() {
		return link_forgotPassword.isDisplayed();
	}
		
	public String getSignInAlerttext() {
		return helper.waitForAlert().getText();
	}
	
	public void acceptSignInAlert() {
		helper.waitForAlert().accept();
	}

}
