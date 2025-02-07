package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObject.DashboardPage;
import pageObject.HomePage;
import pageObject.SignInPage;
import pageObject.SignUpPage;

public class TC_SO_001 extends BaseClass{

	HomePage homepage;
	SignUpPage signuppage;
	SignInPage signinpage;
	DashboardPage dashboardpage;

	@Test()
	void testSignOut() {

		homepage = new HomePage(driver);
		signuppage = new SignUpPage(driver);
		signinpage = new SignInPage(driver);
		dashboardpage = new DashboardPage(driver);
		
		homepage.clickSignin();
		signuppage.goToSignInPage();
				
		boolean verifySignInPage = signinpage.verifySignInPage();
		Assert.assertTrue(verifySignInPage);
		
		signinpage.enterSigninEmail(prop.getProperty("validemail"));
		signinpage.enterSigninPassword(prop.getProperty("validpassword"));
		signinpage.clickSignIn();
		
		boolean verifyUserSignIn = dashboardpage.verifyDashboardPage();
		Assert.assertTrue(verifyUserSignIn);
		
		dashboardpage.clickSignOut();
		
		boolean verifySignout = homepage.verifyHomePage();
		Assert.assertTrue(verifySignout);

	}

}
