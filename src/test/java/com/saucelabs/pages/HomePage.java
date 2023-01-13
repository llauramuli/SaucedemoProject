package com.saucelabs.pages;

import com.saucelabs.utilities.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "inventory_item")
    public List<WebElement> elements;

//    @FindBy()


    public void verifyPage(){
      //  BrowserUtils.pageVerification("Swag Labs", pageTitle);

    }
}
