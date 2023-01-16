package com.saucelabs.tests;

import com.saucelabs.pages.HomePage;
import com.saucelabs.pages.LoginPage;
import com.saucelabs.pages.productDetailsPages.SauceLabsBackpackPage;
import com.saucelabs.pages.productDetailsPages.SauceLabsBikeLightPage;
import com.saucelabs.utilities.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseClass {
    private LoginPage loginPage = new LoginPage();
    public HomePage homePage = new HomePage();

    public SauceLabsBackpackPage sauceLabsBackpackPage = new SauceLabsBackpackPage();

    public SauceLabsBikeLightPage sauceLabsBikeLightPage = new SauceLabsBikeLightPage();

    @Test
    public void totalNumberOfProductsTest(){
        loginPage.LoginValidData();
        Assert.assertEquals(homePage.totalNumberOfProducts(), 6, "Number of elements is not 6!");
    }
    @Test
    public void verifyProductPriceTest(){
        loginPage.LoginValidData();
//        Assert.assertEquals(homePage.getProductPrice(), sauceLabsBackpackPage.getDetailsPrice(), "Price is not the same!");
       Assert.assertEquals(homePage.getProductPrice(), sauceLabsBikeLightPage.getDetailsPrice(), "Price is not the same!");
//       Assert.assertEquals(homePage.getProductPrice(), "$29.99", "Price is not the same!");
//        Assert.assertEquals(homePage.getDetailsPrice(), "$29.99", "Price is not the same!");
    }

}
