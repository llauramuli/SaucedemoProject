package com.saucelabs.tests;

import com.saucelabs.pages.HomePage;
import com.saucelabs.pages.LoginPage;
import com.saucelabs.utilities.BaseClass;
import com.saucelabs.utilities.ConfigurationReader;
import com.saucelabs.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTests extends BaseClass {

    private LoginPage loginPage = new LoginPage();
    private HomePage homePage = new HomePage();

//    @BeforeMethod
//    public void setUp(){
//        driver = Driver.getDriver();
//        driver.get(ConfigurationReader.getProperty("sauce.url"));
//    }

    @Test
    public void loginValidDataTest(){

        loginPage.LoginValidData();
        homePage.verifyPage();
    }

    @Test
    public void loginInvalidDataTest(){
        loginPage.LoginInvalidData();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "Error message is not displayed");
    }

    @Test
    public void LoginEmptyUsernameAndPasswordTest(){
        loginPage.LoginEmptyUsernameAndPassword();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "Error message is not displayed");
    }

    @Test
    public void LoginValidUsernameAndEmptyPasswordTest(){
        loginPage.LoginValidUsernameAndEmptyPassword();;
        Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "Error message is not displayed");

    }

    @Test
    public void LoginValidPasswordAndEmptyUsernameTest(){
        loginPage.LoginValidPasswordAndEmptyUsername();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "Error message is not displayed");
    }
}
