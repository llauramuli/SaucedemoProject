package com.saucelabs.tests;

import com.saucelabs.pages.HomePage;
import com.saucelabs.pages.LoginPage;
import com.saucelabs.pages.productDetailsPages.SauceLabsBackpackPage;
import com.saucelabs.pages.productDetailsPages.SauceLabsBikeLightPage;
import com.saucelabs.utilities.BaseClass;
import com.saucelabs.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseClass {
    private LoginPage loginPage = new LoginPage();
    private HomePage homePage = new HomePage();
    private SauceLabsBackpackPage sauceLabsBackpackPage = new SauceLabsBackpackPage();
    private SauceLabsBikeLightPage sauceLabsBikeLightPage = new SauceLabsBikeLightPage();

    @Test
    public void totalNumberOfProductsTest(){
        loginPage.loginValidData();
        Assert.assertEquals(homePage.totalNumberOfProducts(), 6, "Number of elements is not 6!");
    }

    @Test
    public void verifySauceLabsBackpackProductPriceTest(){
        loginPage.loginValidData();

        homePage.getSauceLabsBackpackProductPrice();
        sauceLabsBackpackPage.getDetailsPrice();

        Assert.assertEquals(homePage.productPrice, sauceLabsBackpackPage.productDetailPrice, "Product price and product detail price is not the same!");
        Assert.assertEquals(homePage.productPrice, "$29.99", "Product price is not the same!");
        Assert.assertEquals(sauceLabsBackpackPage.productDetailPrice, "$29.99", "Product detail price is not the same!");
    }

    @Test
    public void verifySauceLabsBikeLightProductPriceTest(){
        loginPage.loginValidData();

        homePage.getSauceLabsBikeLightProductPrice();
        sauceLabsBikeLightPage.getDetailsPrice();

        Assert.assertEquals(homePage.productPrice, sauceLabsBikeLightPage.productDetailPrice, "Product price and product detail price is not the same!");
        Assert.assertEquals(homePage.productPrice, "$9.99", "Product price is not the same!");
        Assert.assertEquals(sauceLabsBikeLightPage.productDetailPrice, "$9.99", "Product detail price is not the same!");
    }

    @Test
    public void sortProductNamesZToATest() {
        //Arrange
        loginPage.loginValidData();

        //Act
        WaitUtils.sleep(3); //For demo purposes we've added a thread.sleep
        homePage.sortProductNamesZtoA();

        //Assert
        Assert.assertEquals(homePage.sortedProductTitleList, homePage.sortedOriginalProductTitleList, "Product Names not sorting correctly!");
        WaitUtils.sleep(3);
    }

    @Test
    public void sortProductNamesAToZTest() {
        loginPage.loginValidData();

        homePage.sortProductNamesAToZ();

        Assert.assertEquals(homePage.sortedProductTitleList, homePage.sortedOriginalProductTitleList, "Product Names not sorting correctly!");
        WaitUtils.sleep(3);
    }

    @Test
    public void sortProductPriceLowToHighTest() {
        loginPage.loginValidData();

        homePage.sortProductPriceLowToHigh();

        Assert.assertEquals(homePage.sortedProductTitleList, homePage.sortedOriginalProductTitleList, "Product Price not sorting correctly!");
        WaitUtils.sleep(3);
    }

    @Test
    public void sortProductPriceHighToLowTest() {
        loginPage.loginValidData();

        homePage.sortProductPriceHighToLow();

        Assert.assertEquals(homePage.sortedProductTitleList, homePage.sortedOriginalProductTitleList, "Product Price not sorting correctly!");
    }
}
