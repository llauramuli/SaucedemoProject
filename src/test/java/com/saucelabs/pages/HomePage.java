package com.saucelabs.pages;

import com.saucelabs.utilities.BasePage;
import com.saucelabs.utilities.BrowserUtils;
import com.saucelabs.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(className = "inventory_item")
    private List<WebElement> totalProducts;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> productPrices;

    public int totalNumberOfProducts() {
        return totalProducts.size();
    }

    public void verifyHomePage() {
        BrowserUtils.pageVerification("https://www.saucedemo.com/inventory.html", Driver.getDriver().getCurrentUrl());
    }

    public String getProductPrice(){
        return productPrices.get(0).getText();
    }
}