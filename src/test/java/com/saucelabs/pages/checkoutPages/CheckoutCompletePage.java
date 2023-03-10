package com.saucelabs.pages.checkoutPages;

import com.saucelabs.utilities.BasePage;
import com.saucelabs.utilities.BrowserUtils;
import com.saucelabs.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {

    @FindBy(xpath = "//h2[normalize-space()='THANK YOU FOR YOUR ORDER']")
    public WebElement checkoutCompleteTitle;

    public void verifyCompletePage() {
        BrowserUtils.pageVerification("https://www.saucedemo.com/checkout-complete.html", Driver.getDriver().getCurrentUrl());
    }

    public String getPageText() {
        return checkoutCompleteTitle.getText();
    }
}
