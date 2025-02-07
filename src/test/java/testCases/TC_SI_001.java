package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import baseClass.BaseClass;
import pageObject.HomePage;
import pageObject.SignInPage;

public class TC_SI_001 extends BaseClass{
	
	HomePage homepage;
	SignInPage signinpage;
	Faker faker;
	
	@Test()
	public void testSigninPageNavigation() {
		
		homepage = new HomePage(driver);
		signinpage = new SignInPage(driver);
		faker = new Faker();
		
		homepage.clickSignin();
				
		boolean verifySignInPage = signinpage.verifySignInPage();
		
		Assert.assertTrue(verifySignInPage);
		
	}

}
