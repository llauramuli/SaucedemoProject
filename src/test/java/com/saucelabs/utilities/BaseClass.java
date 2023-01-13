package com.saucelabs.utilities;

import com.saucelabs.pages.LoginPage;
import com.saucelabs.pages.LogoutPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseClass {
    public WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
        driver.get(ConfigurationReader.getProperty("sauce.url"));
    }

    @AfterMethod
    public void tearDown(){
       Driver.closeDriver();
    }

}
