package com.saucelabs.pages;

import com.saucelabs.utilities.BasePage;
import com.saucelabs.utilities.BrowserUtils;
import com.saucelabs.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage homePage;
    @FindBy(className = "inventory_item")
    public List<WebElement> totalProducts;

    public int totalNumberOfProducts() {
        return totalProducts.size();
    }

    public void verifyHomePage() {
        BrowserUtils.pageVerification("https://www.saucedemo.com/inventory.html", Driver.getDriver().getCurrentUrl());
    }
}