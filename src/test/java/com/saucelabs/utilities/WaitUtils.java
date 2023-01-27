package com.saucelabs.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    //explicit waits qe kan me u perdor ne framework ex. element.clickable, enabled, visible, notvisible etc...
    //metodat behen statike-nuk kemi nevoje me kriju object te klases
    private static WebDriverWait wait;

    public static void waitUntilElmIsDisplayed(By elm){
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(elm));
    }

    public static void waitUntilElmIsClickable(WebElement elm){
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(elm));
    }

    public static void waitUntilElmIsVisible(By elm){
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elm));
        }

    public static void sleep(int sec){
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
