package com.saucelabs.tests;

import com.saucelabs.pages.HomePage;
import com.saucelabs.pages.LoginPage;
import com.saucelabs.pages.checkoutPages.CartPage;
import com.saucelabs.pages.checkoutPages.CheckoutCompletePage;
import com.saucelabs.pages.checkoutPages.CheckoutInformationPage;
import com.saucelabs.pages.checkoutPages.CheckoutOverviewPage;
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
    @Test
    public void sortProductNamesZToATest() throws InterruptedException {
        loginPage.LoginValidData();
        //for demo purposes we've added a thread.sleep
        Thread.sleep(3000);
        homePage.sortProductNamesZtoA();

        Assert.assertEquals(homePage.sortedProductTitleList, homePage.sortedOriginalProductTitleList, "Product Names not sorting correctly!");
        Thread.sleep(3000);
    }
    @Test
    public void sortProductNamesAToZTest() throws InterruptedException {
        loginPage.LoginValidData();
        homePage.sortProductNamesAToZ();

        Assert.assertEquals(homePage.sortedProductTitleList, homePage.sortedOriginalProductTitleList, "Product Names not sorting correctly!");
        Thread.sleep(3000);
    }
    @Test
    public void sortProductPriceLowToHighTest() throws InterruptedException {
        loginPage.LoginValidData();
        homePage.sortProductPriceLowToHigh();

        Assert.assertEquals(homePage.sortedProductTitleList, homePage.sortedOriginalProductTitleList, "Product Price not sorting correctly!");
        Thread.sleep(3000);
    }
    @Test
    public void sortProductPriceHighToLowTest() {
        loginPage.LoginValidData();
        homePage.sortProductPriceHighToLow();

        Assert.assertEquals(homePage.sortedProductTitleList, homePage.sortedOriginalProductTitleList, "Product Price not sorting correctly!");
    }

    @Test
    public void goToCartTest() throws InterruptedException{
        loginPage.LoginValidData();
        Thread.sleep(3000);
        homePage.goToCart();
        Thread.sleep(3000);

    }
}
