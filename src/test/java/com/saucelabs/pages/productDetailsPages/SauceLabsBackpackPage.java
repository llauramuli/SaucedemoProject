package com.saucelabs.pages.productDetailsPages;

import com.saucelabs.utilities.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SauceLabsBackpackPage  extends BasePage {
    @FindBy(id = "item_4_title_link")
    private WebElement productTitle;

    @FindBy(className = "inventory_details_price")
    private WebElement detailsPrice;

    public String productDetailPrice;

    public void getDetailsPrice(){
        productTitle.click();
        productDetailPrice =  detailsPrice.getText();
    }
}
