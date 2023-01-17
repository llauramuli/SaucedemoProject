package com.saucelabs.pages;

import com.saucelabs.utilities.BasePage;
import com.saucelabs.utilities.BrowserUtils;
import com.saucelabs.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(className = "inventory_item")
    private List<WebElement> productList;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> productPrices;

    public int totalNumberOfProducts() {
        return productList.size();
    }

    @FindBy(className = "product_sort_container")
    private WebElement productSortContainer;

    public void verifyHomePage() {
        BrowserUtils.pageVerification("https://www.saucedemo.com/inventory.html", Driver.getDriver().getCurrentUrl());
    }

    public String getProductPrice(){
        return productPrices.get(1).getText();
    }

    public List<WebElement> getProductList() {
        return productList;
    }

    public List<WebElement> sortProductNamesZToA() {
        BrowserUtils.selectByValue("za", productSortContainer);
        return productList;
    }

    public List<WebElement> sortProductNamesAToZ() {
        BrowserUtils.selectByValue("az", productSortContainer);
        return productList;
    }

    public List<WebElement> sortProductPriceLowToHigh() {
        BrowserUtils.selectByValue("lohi", productSortContainer);
        return productList;
    }

    public List<WebElement> sortProductPriceHighToLow() {
        BrowserUtils.selectByValue("hilo", productSortContainer);
        return productList;
    }

}