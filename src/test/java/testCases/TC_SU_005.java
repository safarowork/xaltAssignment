package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import baseClass.BaseClass;
import pageObject.HomePage;
import pageObject.SignUpPage;

public class TC_SU_005 extends BaseClass{

	HomePage homepage;
	SignUpPage signupPage;
	Faker faker;

	@Test()
	void testSignupMissingPassword() throws IOException, InterruptedException {
		homepage = new HomePage(driver);
		signupPage = new SignUpPage(driver);
		faker = new Faker();

		homepage.clickGetStarted();

		boolean signUpPageValdation = signupPage.verifySignUpPage();
		Assert.assertTrue(signUpPageValdation);

		String email = faker.internet().emailAddress();

		signupPage.enterSignupEmail(email);
		
		boolean MissingPasswordValidation = signupPage.signUpBtnVisibility();
		
		Assert.assertFalse(MissingPasswordValidation); //signUp button is disabled due to missing password
		
	}
}
