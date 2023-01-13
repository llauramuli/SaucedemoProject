package com.saucelabs.pages;

import com.saucelabs.utilities.BasePage;
import com.saucelabs.utilities.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenu;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logout;

    public void userLogout() {
            burgerMenu.click();
            WaitUtils.waitUntilElmIsVisible(By.id("react-burger-menu-btn"));
            logout.click();

        }
}
