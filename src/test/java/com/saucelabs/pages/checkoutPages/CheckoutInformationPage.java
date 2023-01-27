package com.saucelabs.pages.checkoutPages;

import com.saucelabs.utilities.BasePage;
import com.saucelabs.utilities.ConfigurationReader;
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

    public void checkoutInformation(){
        firstName.sendKeys(ConfigurationReader.getProperty("sauce.firstName"));
        lastName.sendKeys(ConfigurationReader.getProperty("sauce.lastName"));
        postalName.sendKeys(ConfigurationReader.getProperty("sauce.postalName"));
        continueButton.click();
    }

}
