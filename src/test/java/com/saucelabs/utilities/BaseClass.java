package com.saucelabs.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

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

    public void FailedScreenshot (String testMethodName) {
        File srcFile = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        LocalDateTime timeNow = LocalDateTime.now();
        String TimeStamp = timeNow.toString().replace(":", "_").replace(" ", "_");
        try {
            FileUtils.copyFile(srcFile, new File("Users/macbook/Downloads/SaucedemoProject/Screenshots/" + testMethodName + "_" + TimeStamp + ".png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
