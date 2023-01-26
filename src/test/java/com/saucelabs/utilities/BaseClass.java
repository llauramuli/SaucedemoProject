package com.saucelabs.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;

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
    @AfterMethod
    public void screenShot(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            try{
                TakesScreenshot scrShot = ((TakesScreenshot) driver);
                File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
                File DestFile = new File("/Users/macbook/Downloads/SaucedemoProject/target/screenshots-for-failed-tests/"
                        + result.getName() + ".png");
                FileUtils.copyFile(SrcFile, DestFile);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


}
