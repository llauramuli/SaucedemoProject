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

    private LoginPage loginPage = new LoginPage();
    private HomePage homePage = new HomePage();
    private CartPage cartPage = new CartPage();
    private CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage();
    private CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
    private CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();


    @Test
    public void orderProcessTest(){
        loginPage.loginWithValidData();
        homePage.goToCart();
        cartPage.addToCart();
        checkoutInformationPage.checkoutInformation();
//        System.out.println(checkoutCompletePage.totalItemSum());
//        System.out.println(checkoutOverviewPage.productTotalPrice());
        Assert.assertEquals(checkoutOverviewPage.totalItemSum(), checkoutOverviewPage.productTotalPrice(),"Calculation doesn't match" );
        Assert.assertEquals(checkoutOverviewPage.totalPriceWithTax(), checkoutOverviewPage.calculateTotalPrice(), "Calculation doesn't match with tax");
        checkoutOverviewPage.completePurchase();
    }
}