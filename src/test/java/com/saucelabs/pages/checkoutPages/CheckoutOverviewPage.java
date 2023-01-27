package com.saucelabs.pages.checkoutPages;

import com.saucelabs.utilities.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutOverviewPage extends BasePage {

    @FindBy(xpath = "//*[@class='inventory_item_price']")
    private List<WebElement> productPrices;

    @FindBy(id = "finish")
    private WebElement finish;

    public double productTotalPrice() {
        String amounts;
        double totalAmount = 0.0;

        for (WebElement elm : productPrices) {
        amounts = elm.getText().substring(1);
        totalAmount += Double.parseDouble(amounts);
        amounts = "";
        }
        return totalAmount;
    }

    public void completePurchase(){
        finish.click();
    }

}
