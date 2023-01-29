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
                TakesScreenshot screenShot = ((TakesScreenshot) driver);
                File sourceFile = screenShot.getScreenshotAs(OutputType.FILE);

                String filePath = "./src/test/java/com/saucelabs/assets/failedTestScreenShots/" + result.getName() + ".png";
                File destinationFile = new File(filePath);

                FileUtils.copyFile(sourceFile, destinationFile);

            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
