package com.saucelabs.pages.checkoutPages;

import com.saucelabs.utilities.BasePage;
import com.saucelabs.utilities.BrowserUtils;
import com.saucelabs.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutOverviewPage extends BasePage {

    @FindBy(xpath = "//*[@class='inventory_item_price']")
    private List<WebElement> productPricesList;
    @FindBy(className = "summary_subtotal_label")
    private WebElement itemTotalPrice;
    @FindBy(className = "summary_tax_label")
    private WebElement taxPrice;
    @FindBy(className = "summary_total_label")
    private WebElement totalPrice;
    @FindBy(id = "finish")
    private WebElement finishButton;

    public void verifyCheckoutStepTwoPage() {
        BrowserUtils.pageVerification("https://www.saucedemo.com/checkout-step-two.html", Driver.getDriver().getCurrentUrl());
    }

    public Double calculateTotalPriceOfProductsInTheCart() {
        Double totalAmount = 0.0;

        for (WebElement productPrice : productPricesList) {
            totalAmount += Double.parseDouble(productPrice.getText().substring(1));
        }
        return totalAmount;
    }

    public Double getItemTotalPrice() {
        return Double.parseDouble(itemTotalPrice.getText().substring(13));
    }

    public Double getTaxPrice() {
        return Double.parseDouble(taxPrice.getText().substring(6));
    }

    public Double getTotalPrice() {
        return Double.parseDouble(totalPrice.getText().substring(8));
    }

    public Double calculateItemTotalPriceWithTax() {
        return getTaxPrice() + getItemTotalPrice();

    }

    public void completePurchase() {
        finishButton.click();
    }
}
