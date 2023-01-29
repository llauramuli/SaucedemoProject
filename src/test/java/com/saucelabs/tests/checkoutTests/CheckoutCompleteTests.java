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


public class CheckoutCompleteTests extends BaseClass {

    private final LoginPage loginPage = new LoginPage();
    private final HomePage homePage = new HomePage();
    private final CartPage cartPage = new CartPage();
    private final CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage();
    private final CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
    private final CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();

    @Test
    public void verifyText(){
        loginPage.verifyLoginPage();
        loginPage.loginWithValidData();
        homePage.verifyHomePage();

        homePage.addProductsToCart();
        homePage.goToCart();

        cartPage.verifyCartPage();
        cartPage.goToCheckoutStepOnePage();

        checkoutInformationPage.verifyCheckoutStepOnePage();
        checkoutInformationPage.fillOutCheckoutInformationWithValidData();
        checkoutOverviewPage.verifyCheckoutStepTwoPage();

        checkoutOverviewPage.completePurchase();
        checkoutCompletePage.verifyCompletePage();
        Assert.assertEquals(checkoutCompletePage.getPageText(), "THANK YOU FOR YOUR ORDER");

    }
}