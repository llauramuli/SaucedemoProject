package com.saucelabs.pages;

import com.saucelabs.utilities.BasePage;
import com.saucelabs.utilities.BrowserUtils;
import com.saucelabs.utilities.ConfigurationReader;
import com.saucelabs.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement login;

    @FindBy(xpath = "//*[contains(text(), 'Epic sadface:')]")
    public WebElement errorMessage;

    public void verifyLoginPage(){
        BrowserUtils.pageVerification("https://www.saucedemo.com/", Driver.getDriver().getCurrentUrl());
    }

    public void LoginValidData (){
        username.sendKeys(ConfigurationReader.getProperty("sauce.username"));
        password.sendKeys(ConfigurationReader.getProperty("sauce.password"));
        login.click();
    }

    public void LoginInvalidData (){
        username.sendKeys("sauce.username");
        password.sendKeys("testtesttest");
        login.click();
    }

    public void LoginEmptyUsernameAndPassword(){
        username.sendKeys("");
        password.sendKeys("");
        login.click();
    }

    public void LoginValidUsernameAndEmptyPassword(){
        username.sendKeys("sauce.username");
        password.sendKeys("");
        login.click();
    }

    public void LoginValidPasswordAndEmptyUsername(){
        username.sendKeys("");
        password.sendKeys("sauce.password");
        login.click();
    }



//    @FindBy(id=)
    // variablat deklarohen private - metodat krijohen publike
    // per cdo faqe krijohet nje page ne vete
    //
}
