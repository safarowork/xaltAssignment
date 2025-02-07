package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import baseClass.BaseClass;
import pageObject.HomePage;
import pageObject.SignUpPage;

public class TC_SU_003 extends BaseClass{

	HomePage homepage;
	SignUpPage signupPage;
	Faker faker;

	@Test()
	void testSignupInvalidPassword() throws IOException, InterruptedException {
		homepage = new HomePage(driver);
		signupPage = new SignUpPage(driver);
		faker = new Faker();

		homepage.clickGetStarted();

		boolean signUpPageValdation = signupPage.verifySignUpPage();
		Assert.assertTrue(signUpPageValdation);

		String email = faker.internet().emailAddress();
		String password = faker.internet().password(5, 7);

		signupPage.enterSignupEmail(email);
		signupPage.enterSignupPassword(password);
		signupPage.enterSignupConfirmPassword(password);
		
		boolean invalidPasswordValidation = signupPage.signUpBtnVisibility();
		boolean psswordCriteriaDisplay = signupPage.displayPasswordComplexity();
		
		Assert.assertTrue(psswordCriteriaDisplay);
		Assert.assertFalse(invalidPasswordValidation); //signUp button is disabled due to invalid password
		
	}
}
