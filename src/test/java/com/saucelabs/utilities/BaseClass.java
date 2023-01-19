package com.saucelabs.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public abstract class BaseClass {
    public WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
        driver.get(ConfigurationReader.getProperty("sauce.url"));
    }

    @AfterSuite
    public void tearDown(){
        Driver.closeDriver();
    }

}
