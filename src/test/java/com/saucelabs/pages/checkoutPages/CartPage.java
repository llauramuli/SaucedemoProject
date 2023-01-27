package com.saucelabs.pages.checkoutPages;

import com.saucelabs.utilities.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(id = "checkout")
    private WebElement checkout;

    public void addToCart(){
        checkout.click();
    }
}
