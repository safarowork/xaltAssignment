package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import baseClass.BaseClass;
import pageObject.HomePage;
import pageObject.SignUpPage;

public class TC_SU_004 extends BaseClass{

	HomePage homepage;
	SignUpPage signupPage;
	Faker faker;

	@Test()
	void testSignupPasswordMismatch() throws IOException, InterruptedException {
		homepage = new HomePage(driver);
		signupPage = new SignUpPage(driver);
		faker = new Faker();

		homepage.clickGetStarted();

		boolean signUpPageValdation = signupPage.verifySignUpPage();
		Assert.assertTrue(signUpPageValdation);

		String email = faker.internet().emailAddress();
		String password = faker.internet().password(8, 10, true, true, true);
		String confirmpwd = faker.internet().password();

		signupPage.enterSignupEmail(email);
		signupPage.enterSignupPassword(password);
		signupPage.enterSignupConfirmPassword(confirmpwd);
		
		boolean PasswordMismatchValidation = signupPage.signUpBtnVisibility();
		boolean passwordMismatchDisplay = signupPage.displayPasswordMismatch();
		
		Assert.assertTrue(passwordMismatchDisplay); 
		Assert.assertFalse(PasswordMismatchValidation); //signUp button is disabled due to invalid password
		
	}
}
