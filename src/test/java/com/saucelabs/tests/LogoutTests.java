package com.saucelabs.tests;

import com.saucelabs.pages.HomePage;
import com.saucelabs.pages.LoginPage;
import com.saucelabs.pages.LogoutPage;
import com.saucelabs.utilities.BaseClass;
import com.saucelabs.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTests extends BaseClass {
    private LoginPage loginPage = new LoginPage();
    private HomePage homePage = new HomePage();
    private LogoutPage logoutPage = new LogoutPage();
//    private String expUrl = "https://www.saucedemo.com/";

    @Test
    public void userLogoutTest()  {
        loginPage.loginWithValidData();
        logoutPage.userLogout();
//        Assert.assertTrue(driver.getCurrentUrl().equals(expUrl));
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.saucedemo.com/");
    }
}
