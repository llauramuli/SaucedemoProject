package com.saucelabs.pages;

import com.saucelabs.utilities.BasePage;
import com.saucelabs.utilities.BrowserUtils;
import com.saucelabs.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "inventory_item")
    public List<WebElement> elements;

     //@FindBy()

    public void verifyLoginPage(){
        BrowserUtils.pageVerification("https://www.saucedemo.com/", Driver.getDriver().getCurrentUrl());
    }
    public void verifyHomePage(){
        BrowserUtils.pageVerification("https://www.saucedemo.com/inventory.html", Driver.getDriver().getCurrentUrl());
    }
}
