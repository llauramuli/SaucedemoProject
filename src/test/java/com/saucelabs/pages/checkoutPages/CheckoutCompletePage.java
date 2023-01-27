package com.saucelabs.pages.checkoutPages;

import com.saucelabs.utilities.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {

    @FindBy(className = "summary_subtotal_label")
    private WebElement itemTotal;

    @FindBy(className = "summary_tax_label")
    private WebElement tax;

    @FindBy(className = "summary_total_label")
    private WebElement totalPrice;

    public double totalItemSum() {
        String str;
        double totalAmount = 0.00;

        str = itemTotal.getText().substring(13); // sa karaktere deri te cmimi
        totalAmount += Double.parseDouble(str);

        return totalAmount;
    }

    public double calculateTax(){
        String str;
        double totalAmount = 0.00;

        str = tax.getText().substring(6); // sa karaktere deri te cmimi
        totalAmount += Double.parseDouble(str);

        return totalAmount;
    }

    public double totalPriceWithTax(){
        String str;
        double totalAmount = 0.00;

        str = totalPrice.getText().substring(8); // sa karaktere deri te cmimi
        totalAmount += Double.parseDouble(str);

        return totalAmount;
    }

    public double calculateTotalPrice(){
        double totalAmount = calculateTax() + totalItemSum();

        return totalAmount;

    }

}
