package com.saucelabs.tests;

import com.saucelabs.pages.HomePage;
import com.saucelabs.pages.LoginPage;
import com.saucelabs.utilities.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseClass {

    private LoginPage loginPage = new LoginPage();
    private HomePage homePage = new HomePage();

    @Test
    public void loginValidDataTest(){
        loginPage.verifyLoginPage();
        loginPage.loginWithValidData();
        homePage.verifyHomePage();
    }

    @Test
    public void loginInvalidDataTest(){
        loginPage.loginWithInvalidData();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "Error message is not displayed");
    }

    @Test
    public void LoginEmptyUsernameAndPasswordTest(){
        loginPage.loginWithEmptyUsernameAndPassword();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "Error message is not displayed");
    }

    @Test
    public void LoginValidUsernameAndEmptyPasswordTest(){
        loginPage.loginWithValidUsernameAndEmptyPassword();;
        Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "Error message is not displayed");

    }

    @Test
    public void LoginValidPasswordAndEmptyUsernameTest(){
        loginPage.loginWithValidPasswordAndEmptyUsername();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "Error message is not displayed");
    }
}
