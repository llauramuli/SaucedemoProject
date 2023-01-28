package com.saucelabs.tests;

import com.saucelabs.pages.HomePage;
import com.saucelabs.pages.LoginPage;
import com.saucelabs.utilities.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseClass {

    private final LoginPage loginPage = new LoginPage();
    private final HomePage homePage = new HomePage();

    @Test
    public void loginWithValidDataTest() {
        //Arrange
        loginPage.verifyLoginPage();

        //Act
        loginPage.loginWithValidData();

        //Assert
        homePage.verifyHomePage();
    }

    @Test
    public void loginWithInvalidDataTest() {
        loginPage.verifyLoginPage();

        loginPage.loginWithInvalidData();

        Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "Error message is not displayed");
    }

    @Test
    public void loginWithEmptyUsernameAndPasswordTest() {
        loginPage.verifyLoginPage();

        loginPage.loginWithEmptyUsernameAndPassword();

        Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "Error message is not displayed");
    }

    @Test
    public void loginWithValidUsernameAndEmptyPasswordTest() {
        loginPage.verifyLoginPage();

        loginPage.loginWithValidUsernameAndEmptyPassword();

        Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "Error message is not displayed");

    }

    @Test
    public void loginWithValidPasswordAndEmptyUsernameTest() {
        loginPage.verifyLoginPage();

        loginPage.loginWithValidPasswordAndEmptyUsername();

        Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "Error message is not displayed");
    }
}
