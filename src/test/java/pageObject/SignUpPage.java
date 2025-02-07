package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.Helpers;

public class SignUpPage extends BasePage{
	
	Helpers helper;

	public SignUpPage(WebDriver driver) {
		super(driver);
		helper = new Helpers(driver);
	}
	
	@FindBy(xpath = "//button[contains(text(),'sign in')]")
	private WebElement link_signIn;
		
	@FindBy(xpath = "//label[text()='E-Mail']//parent::div//descendant::input")
	private WebElement txt_email;
		
	@FindBy(xpath = "//label[text()='Password']//parent::div//descendant::input")
	private WebElement txt_password;
	
	@FindBy(xpath = "//label[text()='Confirm Password']//parent::div//descendant::input")
	private WebElement txt_confirmPassword;
	
	@FindBy(xpath = "//p[@id='outlined-basic-helper-text']")
	private WebElement display_passwordComplexity;
	
	@FindBy(xpath = "//p[text()='Passwords do not match']")
	private WebElement display_passwordMismatch;
	
	@FindBy(xpath = "//button[text()='Sign Up']")
	private WebElement btn_signUp;
	
	
	public boolean verifySignUpPage() {
		return link_signIn.isDisplayed();
	}
	
	public void enterSignupEmail(String email) {
		txt_email.sendKeys(email);
	}
	
	public void enterSignupPassword(String password) {
		helper.waitForVisibilityOfElement(txt_password).sendKeys(password);
	}
	
	public void enterSignupConfirmPassword(String password) {
		helper.waitForVisibilityOfElement(txt_confirmPassword).sendKeys(password);
	}
	
	public void clickSignUp() {
		helper.javaScriptClick(helper.waitForVisibilityOfElement(btn_signUp));
	}
	
	public boolean signUpBtnVisibility() {
		return btn_signUp.isEnabled();
	}
	
	public boolean displayPasswordComplexity() {
		return display_passwordComplexity.isDisplayed();
	}
	
	public boolean displayPasswordMismatch() {
		return display_passwordMismatch.isDisplayed();
	}
	
	public boolean verifyPasswordToggled() {
		if(txt_password.getDomProperty("type").equals("password"))
			return true;
		else
			return false;
	}
	
	public String getSignUpAlerttext() {
		return helper.waitForAlert().getText();
	}
	
	public void acceptSignUpAlert() {
		helper.waitForAlert().accept();
	}
	
	public void goToSignInPage() {
		link_signIn.click();
	}

}
