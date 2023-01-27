package com.saucelabs.pages;

import com.saucelabs.utilities.BasePage;
import com.saucelabs.utilities.BrowserUtils;
import com.saucelabs.utilities.Driver;
import com.saucelabs.utilities.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(className = "inventory_item")
    private List<WebElement> productList;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> productPrices;

    @FindBy(className = "product_sort_container")
    private WebElement productSortContainer;

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    private WebElement sauceLabsBackpack;

    @FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement sauceLabsBoltTShirt;

    @FindBy(id="add-to-cart-sauce-labs-fleece-jacket")
    private WebElement sauceLabsFleeceJacket;

    @FindBy(className = "shopping_cart_link")
    private WebElement addToCart;


    public void verifyHomePage() {
        BrowserUtils.pageVerification("https://www.saucedemo.com/inventory.html", Driver.getDriver().getCurrentUrl());
    }

    public String getProductPrice() {
        return productPrices.get(1).getText();
    }

    public int totalNumberOfProducts() {
        return productList.size();
    }

    public List<String> sortedOriginalProductTitleList;

    public List<String> sortedProductTitleList;

    public void sortProductNamesZtoA() throws InterruptedException {
        WaitUtils.waitUntilElmIsVisible(By.className("active_option"));
        BrowserUtils.selectByValue("za", productSortContainer);
        // Since product list is *pass-by-reference* we need to create a copy of that list and paste it into a new list called original product list
        List<WebElement> originalProductList = new ArrayList<>(productList);
        List<WebElement> sortedList = productList;
        sortedOriginalProductTitleList = originalProductList.stream().map(originalProduct -> originalProduct.findElements(By.className("inventory_item_name")).get(0).getText()).sorted(Comparator.reverseOrder()).toList();
        sortedProductTitleList = sortedList.stream().map(originalProduct -> originalProduct.findElements(By.className("inventory_item_name")).get(0).getText()).toList();
    }

    public void sortProductNamesAToZ() {
        WaitUtils.waitUntilElmIsVisible(By.className("active_option"));
        BrowserUtils.selectByValue("az", productSortContainer);
        // Since product list is *pass-by-reference* we need to create a copy of that list and paste it into a new list called original product list
        List<WebElement> originalProductList = new ArrayList<>(productList);
        List<WebElement> sortedList = productList;
        sortedOriginalProductTitleList = originalProductList.stream().map(originalProduct -> originalProduct.findElements(By.className("inventory_item_name")).get(0).getText()).sorted().toList();
        sortedProductTitleList = sortedList.stream().map(originalProduct -> originalProduct.findElements(By.className("inventory_item_name")).get(0).getText()).toList();

    }

    public void sortProductPriceLowToHigh() {
        WaitUtils.waitUntilElmIsVisible(By.className("active_option"));
        BrowserUtils.selectByValue("lohi", productSortContainer);
        // Since product list is *pass-by-reference* we need to create a copy of that list and paste it into a new list called original product list
        List<WebElement> originalProductList = new ArrayList<>(productList);
        List<WebElement> sortedList = productList;
        List<Double> sortedOriginalProductTitleList = originalProductList
                .stream()
                .map(originalProduct -> originalProduct.findElements(By.className("inventory_item_price")).get(0).getText())
                .map(price -> price.substring(1))
                .map(Double::valueOf)
                .sorted()
                .toList();

        List<Double> sortedProductTitleList = sortedList
                .stream()
                .map(originalProduct -> originalProduct.findElements(By.className("inventory_item_price")).get(0).getText())
                .map(price -> price.substring(1))
                .map(Double::valueOf)
                .toList();
    }

    public void sortProductPriceHighToLow() {
        WaitUtils.waitUntilElmIsVisible(By.className("active_option"));
        BrowserUtils.selectByValue("hilo", productSortContainer);
        // Since product list is *pass-by-reference* we need to create a copy of that list and paste it into a new list called original product list
        List<WebElement> originalProductList = new ArrayList<>(productList);
        List<WebElement> sortedList = productList;
        List<Double> sortedOriginalProductTitleList = originalProductList
                .stream()
                .map(originalProduct -> originalProduct.findElements(By.className("inventory_item_price")).get(0).getText())
                .map(price -> price.substring(1))
                .map(Double::valueOf)
                .sorted(Comparator.reverseOrder())
                .toList();

        List<Double> sortedProductTitleList = sortedList
                .stream()
                .map(originalProduct -> originalProduct.findElements(By.className("inventory_item_price")).get(0).getText())
                .map(price -> price.substring(1))
                .map(Double::valueOf)
                .toList();
    }

    public void goToCart(){
        sauceLabsBackpack.click();
        sauceLabsBoltTShirt.click();
        sauceLabsFleeceJacket.click();
        addToCart.click();

    }

}