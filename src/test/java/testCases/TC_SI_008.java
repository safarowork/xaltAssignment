package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import baseClass.BaseClass;
import pageObject.HomePage;
import pageObject.SignInPage;
import pageObject.SignUpPage;

public class TC_SI_008 extends BaseClass{
	
	HomePage homepage;
	SignUpPage signuppage;
	SignInPage signinpage;
	Faker faker;
	
	@Test()
	public void testSigninNoCredentials() {
		
		homepage = new HomePage(driver);
		signuppage = new SignUpPage(driver);
		signinpage = new SignInPage(driver);
		faker = new Faker();
		
		homepage.clickSignin();
		signuppage.goToSignInPage();
				
		boolean verifySignInPage = signinpage.verifySignInPage();
		Assert.assertTrue(verifySignInPage);
		
		boolean invalidEmailFormat = signinpage.signInBtnVisibility();
		Assert.assertFalse(invalidEmailFormat);		
	}

}
