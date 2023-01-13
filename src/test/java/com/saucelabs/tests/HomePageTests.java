package com.saucelabs.tests;

import com.saucelabs.pages.HomePage;
import com.saucelabs.pages.LoginPage;
import com.saucelabs.utilities.BaseClass;
import com.saucelabs.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseClass {

    public HomePage homePage;

    public void test(){
        Assert.assertEquals(homePage.elements.size(), 6, "Number of elements is not 6!");

        for (WebElement elm: homePage.elements) {
            elm.click();
            Driver.getDriver().navigate().back();
        }
    }
}
