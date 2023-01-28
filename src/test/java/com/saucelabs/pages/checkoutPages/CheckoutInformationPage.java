package com.saucelabs.pages.checkoutPages;

import com.saucelabs.utilities.BasePage;
import com.saucelabs.utilities.BrowserUtils;
import com.saucelabs.utilities.ConfigurationReader;
import com.saucelabs.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutInformationPage extends BasePage {

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalName;

    @FindBy(id = "continue")
    private WebElement continueButton;

    public void verifyCheckoutStepOnePage() {
        BrowserUtils.pageVerification("https://www.saucedemo.com/checkout-step-one.html", Driver.getDriver().getCurrentUrl());
    }

    public void fillOutCheckoutInformationWithValidData() {
        firstName.sendKeys(ConfigurationReader.getProperty("sauce.firstName"));
        lastName.sendKeys(ConfigurationReader.getProperty("sauce.lastName"));
        postalName.sendKeys(ConfigurationReader.getProperty("sauce.postalName"));
        continueButton.click();
    }
}
