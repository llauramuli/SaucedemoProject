package com.saucelabs.tests;

import com.saucelabs.pages.HomePage;
import com.saucelabs.pages.LoginPage;
import com.saucelabs.pages.LogoutPage;
import com.saucelabs.utilities.BaseClass;
import org.testng.annotations.Test;

public class LogoutTests extends BaseClass {
    private final LoginPage loginPage = new LoginPage();
    private final HomePage homePage = new HomePage();
    private final LogoutPage logoutPage = new LogoutPage();

    @Test
    public void userLogoutTest() {
        //Arrange
        loginPage.loginWithValidData();
        homePage.verifyHomePage();

        //Act
        logoutPage.userLogout();

        //Assert
        loginPage.verifyLoginPage();
    }
}
