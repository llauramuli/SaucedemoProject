package com.saucelabs.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

public abstract class BaseClass {
    public WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
        driver.get(ConfigurationReader.getProperty("sauce.url"));
    }

    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }

}
