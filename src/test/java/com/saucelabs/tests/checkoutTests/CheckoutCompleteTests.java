package com.saucelabs.tests.checkoutTests;

import com.saucelabs.pages.checkoutPages.CheckoutCompletePage;
import com.saucelabs.utilities.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckoutCompleteTests extends BaseClass {
    private final CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();

    @Test
    public void verifyText(){
        Assert.assertEquals(checkoutCompletePage.getPageText(), "THANK YOU FOR YOUR ORDER");
    }
}