package com.saucelabs.utilities;

import org.testng.ITestResult;

public abstract class TestStatusListener extends BaseClass implements ITestResult {
    public void onTestFailure(ITestResult results){
        System.out.println("Test case failed");
        try{
            FailedScreenshot(results.getName());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
