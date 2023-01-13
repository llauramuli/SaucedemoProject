package com.saucelabs.tests;

import com.saucelabs.pages.HomePage;
import com.saucelabs.pages.LoginPage;
import com.saucelabs.pages.LogoutPage;
import com.saucelabs.utilities.BaseClass;
import org.testng.annotations.Test;

public class LogoutTests extends BaseClass {
    private LoginPage loginPage = new LoginPage();
    private HomePage homePage = new HomePage();
    private LogoutPage logoutPage = new LogoutPage();

    @Test
    public void userLogoutTest()  {
        loginPage.LoginValidData();
        homePage.verifyPage();
        logoutPage.userLogout();
    }
}
