package com.saucelabs.tests.checkoutTests;

import com.saucelabs.pages.HomePage;
import com.saucelabs.pages.LoginPage;
import com.saucelabs.pages.checkoutPages.CartPage;
import com.saucelabs.pages.checkoutPages.CheckoutCompletePage;
import com.saucelabs.pages.checkoutPages.CheckoutInformationPage;
import com.saucelabs.pages.checkoutPages.CheckoutOverviewPage;
import com.saucelabs.utilities.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutOverviewTests extends BaseClass {

    private final LoginPage loginPage = new LoginPage();
    private final HomePage homePage = new HomePage();
    private final CartPage cartPage = new CartPage();
    private final CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage();
    private final CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
    private final CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();


    @Test
    public void completeCheckoutProcessSuccessfullyTest() {
        //Arrange
        loginPage.verifyLoginPage();
        loginPage.loginWithValidData();
        homePage.verifyHomePage();

        //Act
        homePage.addProductsToCart();
        homePage.goToCart();

        cartPage.verifyCartPage();
        cartPage.goToCheckoutStepOnePage();

        checkoutInformationPage.verifyCheckoutStepOnePage();
        checkoutInformationPage.fillOutCheckoutInformationWithValidData();
        checkoutOverviewPage.verifyCheckoutStepTwoPage();

        //Assert
        Assert.assertEquals(checkoutOverviewPage.getItemTotalPrice(), checkoutOverviewPage.calculateTotalPriceOfProductsInTheCart(), "Item total price and calculated total price doesn't match!");
        Assert.assertEquals(checkoutOverviewPage.getTotalPrice(), checkoutOverviewPage.calculateItemTotalPriceWithTax(), "Total price and calculated item total price with tax doesn't match!");
        checkoutOverviewPage.completePurchase();
        checkoutCompletePage.verifyCompletePage();
    }
}