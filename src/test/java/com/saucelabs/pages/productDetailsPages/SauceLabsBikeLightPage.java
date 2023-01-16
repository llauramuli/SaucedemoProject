package com.saucelabs.pages.productDetailsPages;

import com.saucelabs.utilities.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SauceLabsBikeLightPage extends BasePage {
    @FindBy(id = "item_0_title_link")
    private WebElement productTitle;

    @FindBy(className = "inventory_details_price")
    private WebElement detailsPrice;

    public String getDetailsPrice(){
        productTitle.click();
        return detailsPrice.getText();
    }
}
