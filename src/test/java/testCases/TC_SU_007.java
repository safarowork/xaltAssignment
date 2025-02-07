package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import baseClass.BaseClass;
import pageObject.HomePage;
import pageObject.SignUpPage;

public class TC_SU_007 extends BaseClass{

	HomePage homepage;
	SignUpPage signupPage;
	Faker faker;

	@Test()
	void testSignupToggledPassword() throws IOException, InterruptedException {
		homepage = new HomePage(driver);
		signupPage = new SignUpPage(driver);
		faker = new Faker();

		homepage.clickGetStarted();

		boolean signUpPageValdation = signupPage.verifySignUpPage();
		Assert.assertTrue(signUpPageValdation);

		String password = faker.internet().password(8, 10, true, true, true);

		signupPage.enterSignupPassword(password);
		
		boolean passwordToggleValidation = signupPage.verifyPasswordToggled();
		
		Assert.assertTrue(passwordToggleValidation); //signUp button is disabled due to missing password
		
	}
}
