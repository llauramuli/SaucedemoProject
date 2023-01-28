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
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement sauceLabsBackpackAddToCartButton;
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement sauceLabsBoltTShirtAddToCartButton;
    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement sauceLabsFleeceJacketAddToCartButton;
    @FindBy(className = "shopping_cart_link")
    private WebElement addToCartElement;
    public List<String> sortedOriginalProductListByTitle;
    public List<String> sortedProductListByTitle;
    public List<Double> sortedOriginalProductListByPrice;
    public List<Double> sortedProductListByPrice;

    public String productPrice;

    public void verifyHomePage() {
        BrowserUtils.pageVerification("https://www.saucedemo.com/inventory.html", Driver.getDriver().getCurrentUrl());
    }

    public void getSauceLabsBackpackProductPrice() {
        productPrice = productPrices.get(0).getText();
    }

    public void getSauceLabsBikeLightProductPrice() {
        productPrice = productPrices.get(1).getText();
    }

    public int getTotalNumberOfProducts() {
        return productList.size();
    }

    public void sortProductsByNameUsingZToASort() {
        List<WebElement> originalProductList = new ArrayList<>(productList);

        WaitUtils.waitUntilElmIsVisible(By.className("active_option"));
        BrowserUtils.selectByValue("za", productSortContainer);

        sortedOriginalProductListByTitle = originalProductList
                .stream()
                .map(originalProduct -> originalProduct.findElements(By.className("inventory_item_name")).get(0).getText()) // "light", "backpack", "bike"
                .sorted(Comparator.reverseOrder()).toList(); // "backpack", "bike", "light"

        sortedProductListByTitle = productList
                .stream()
                .map(originalProduct -> originalProduct.findElements(By.className("inventory_item_name")).get(0).getText())
                .toList();
    }

    public void sortProductsByNameUsingAToZSort() {
        List<WebElement> originalProductList = new ArrayList<>(productList);
        WaitUtils.waitUntilElmIsVisible(By.className("active_option"));
        BrowserUtils.selectByValue("az", productSortContainer);

        sortedOriginalProductListByTitle = originalProductList
                .stream()
                .map(originalProduct -> originalProduct.findElements(By.className("inventory_item_name")).get(0).getText())
                .sorted()
                .toList();

        sortedProductListByTitle = productList
                .stream()
                .map(originalProduct -> originalProduct.findElements(By.className("inventory_item_name")).get(0).getText())
                .toList();

    }

    public void sortProductsByPriceUsingLowToHighSort() {
        List<WebElement> originalProductList = new ArrayList<>(productList);
        WaitUtils.waitUntilElmIsVisible(By.className("active_option"));
        BrowserUtils.selectByValue("lohi", productSortContainer);

        sortedOriginalProductListByPrice = originalProductList
                .stream()
                .map(originalProduct -> originalProduct.findElements(By.className("inventory_item_price")).get(0).getText()) // "$29.99", "$9.99"
                .map(price -> price.substring(1))// "29.99", "9.99" - still a list of strings
                .map(Double::valueOf)// Double.valueOf(element);
                .sorted()
                .toList();

        sortedProductListByPrice = productList
                .stream()
                .map(originalProduct -> originalProduct.findElements(By.className("inventory_item_price")).get(0).getText())
                .map(price -> price.substring(1))
                .map(Double::valueOf)
                .toList();
    }

    public void sortProductsByPriceUsingHighToLowSort() {
        List<WebElement> originalProductList = new ArrayList<>(productList);
        WaitUtils.waitUntilElmIsVisible(By.className("active_option"));
        BrowserUtils.selectByValue("hilo", productSortContainer);

        sortedOriginalProductListByPrice = originalProductList
                .stream()
                .map(originalProduct -> originalProduct.findElements(By.className("inventory_item_price")).get(0).getText())
                .map(price -> price.substring(1))
                .map(Double::valueOf)
                .sorted(Comparator.reverseOrder())
                .toList();

        sortedProductListByPrice = productList
                .stream()
                .map(originalProduct -> originalProduct.findElements(By.className("inventory_item_price")).get(0).getText())
                .map(price -> price.substring(1))
                .map(Double::valueOf)
                .toList();
    }

    public void addProductsToCart() {
        sauceLabsBackpackAddToCartButton.click();
        sauceLabsBoltTShirtAddToCartButton.click();
        sauceLabsFleeceJacketAddToCartButton.click();
    }

    public void goToCart() {
        WaitUtils.waitUntilElmIsClickable(addToCartElement);
        addToCartElement.click();
    }

}