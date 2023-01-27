package com.saucelabs.tests;

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

    public HomePage homePage = new HomePage();

    public CartPage cartPage = new CartPage();

    public CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage();

    public CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();

    public CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();


    @Test
    public void orderProcessTest(){
        loginPage.LoginValidData();
        homePage.goToCart();
        cartPage.addToCart();
        checkoutInformationPage.checkoutInformation();
//        System.out.println(checkoutCompletePage.totalItemSum());
//        System.out.println(checkoutOverviewPage.productTotalPrice());
        Assert.assertEquals(checkoutCompletePage.totalItemSum(), checkoutOverviewPage.productTotalPrice(),"Calculation doesn't match" );
        Assert.assertEquals(checkoutCompletePage.totalPriceWithTax(), checkoutCompletePage.calculateTotalPrice(), "Calculation doesn't match with tax");
        checkoutOverviewPage.completePurchase();
    }
}