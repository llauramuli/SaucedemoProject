package com.saucelabs.pages.checkoutPages;

import com.saucelabs.utilities.BasePage;
import com.saucelabs.utilities.BrowserUtils;
import com.saucelabs.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(id = "checkout")
    private WebElement checkout;

    public void verifyCartPage() {
        BrowserUtils.pageVerification("https://www.saucedemo.com/cart.html", Driver.getDriver().getCurrentUrl());
    }

    public void goToCheckoutStepOnePage(){
        checkout.click();
    }
}
