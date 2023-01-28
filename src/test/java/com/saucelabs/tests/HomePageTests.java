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
    private final LoginPage loginPage = new LoginPage();
    private final HomePage homePage = new HomePage();
    private final SauceLabsBackpackPage sauceLabsBackpackPage = new SauceLabsBackpackPage();
    private final SauceLabsBikeLightPage sauceLabsBikeLightPage = new SauceLabsBikeLightPage();

    @Test
    public void verifyTotalNumberOfProductsTest() {
        loginPage.loginWithValidData();

        Assert.assertEquals(homePage.getTotalNumberOfProducts(), 6, "Total number of products is not 6!");
    }

    @Test
    public void verifySauceLabsBackpackProductPriceTest() {
        //Arrange
        loginPage.loginWithValidData();

        //Act
        homePage.getSauceLabsBackpackProductPrice();
        sauceLabsBackpackPage.getDetailsPrice();

        //Assert
        Assert.assertEquals(homePage.productPrice, sauceLabsBackpackPage.productDetailPrice, "Product price and product detail price is not the same!");
        Assert.assertEquals(homePage.productPrice, "$29.99", "Product price is not $29.99!");
        Assert.assertEquals(sauceLabsBackpackPage.productDetailPrice, "$29.99", "Product detail price is not $29.99!");
    }

    @Test
    public void verifySauceLabsBikeLightProductPriceTest() {
        loginPage.loginWithValidData();

        homePage.getSauceLabsBikeLightProductPrice();
        sauceLabsBikeLightPage.getDetailsPrice();

        Assert.assertEquals(homePage.productPrice, sauceLabsBikeLightPage.productDetailPrice, "Product price and product detail price is not the same!");
        Assert.assertEquals(homePage.productPrice, "$9.99", "Product price is not $9.99!");
        Assert.assertEquals(sauceLabsBikeLightPage.productDetailPrice, "$9.99", "Product detail price is not $9.99!");
    }

    @Test
    public void sortProductsByNameUsingZToASortTest() {
        loginPage.loginWithValidData();

        WaitUtils.sleep(3); //Added for demo purposes
        homePage.sortProductsByNameUsingZToASort();

        Assert.assertEquals(homePage.sortedProductListByTitle, homePage.sortedOriginalProductListByTitle, "Products are not sorted correctly by 'names Z to A' sort!");
    }

    @Test
    public void sortProductsByNameUsingAToZSortTest() {
        loginPage.loginWithValidData();

        homePage.sortProductsByNameUsingAToZSort();

        Assert.assertEquals(homePage.sortedProductListByTitle, homePage.sortedOriginalProductListByTitle, "Products are not sorted correctly by 'names A to Z' sort!");
    }

    @Test
    public void sortProductsByPriceUsingLowToHighSortTest() {
        loginPage.loginWithValidData();

        homePage.sortProductsByPriceUsingLowToHighSort();

        Assert.assertEquals(homePage.sortedProductListByTitle, homePage.sortedOriginalProductListByTitle, "Products are not sorted correctly by 'prices low to high' sort!");
    }

    @Test
    public void sortProductsByPriceUsingHighToLowSortTest() {
        loginPage.loginWithValidData();

        homePage.sortProductsByPriceUsingHighToLowSort();

        Assert.assertEquals(homePage.sortedProductListByTitle, homePage.sortedOriginalProductListByTitle, "Products are not sorted correctly by 'prices high to low' sort!");
    }
}
