package com.saucelabs.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BrowserUtils {
    // Te gjitha metodat qe perdoren me se shpeshti ne te gjithe framework
    // select, actions, frames windowhandles...

    public static void pageVerification(String expected, String url){
        Assert.assertEquals(expected, url);
    }
    public static void selectByValue(String str, WebElement elm){
        Select select = new Select(elm);
        select.selectByValue(str);
    }
}
