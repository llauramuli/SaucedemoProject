package com.saucelabs.tests;

import com.saucelabs.pages.HomePage;
import com.saucelabs.pages.LoginPage;
import com.saucelabs.utilities.BaseClass;
import org.testng.annotations.Test;

public class HomePageTests extends BaseClass {
    private LoginPage loginPage = new LoginPage();
    public HomePage homePage = new HomePage();

    @Test
    public void totalNumberOfProductsTest(){
        loginPage.LoginValidData();
        homePage.totalNumberOfProducts();
    }
}
