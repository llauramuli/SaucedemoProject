package com.saucelabs.tests;

import com.saucelabs.pages.HomePage;
import com.saucelabs.pages.LoginPage;
import com.saucelabs.pages.productDetailsPages.SauceLabsBackpackPage;
import com.saucelabs.pages.productDetailsPages.SauceLabsBikeLightPage;
import com.saucelabs.utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HomePageTests extends BaseClass {
    private LoginPage loginPage = new LoginPage();
    public HomePage homePage = new HomePage();

    public SauceLabsBackpackPage sauceLabsBackpackPage = new SauceLabsBackpackPage();
    public SauceLabsBikeLightPage sauceLabsBikeLightPage = new SauceLabsBikeLightPage();

    @Test
    public void totalNumberOfProductsTest(){
        loginPage.LoginValidData();
        Assert.assertEquals(homePage.totalNumberOfProducts(), 6, "Number of elements is not 6!");
    }
    @Test
    public void verifyProductPriceTest(){
        loginPage.LoginValidData();
//        Assert.assertEquals(homePage.getProductPrice(), sauceLabsBackpackPage.getDetailsPrice(), "Price is not the same!");
       Assert.assertEquals(homePage.getProductPrice(), sauceLabsBikeLightPage.getDetailsPrice(), "Price is not the same!");
//       Assert.assertEquals(homePage.getProductPrice(), "$29.99", "Price is not the same!");
//        Assert.assertEquals(homePage.getDetailsPrice(), "$29.99", "Price is not the same!");
    }


    @Test
    public void sortProductNamesZToA() {
        loginPage.LoginValidData();
        // Since product list is *pass-by-reference* we need to create a copy of that list and paste it into a new list called original product list
        List<WebElement> originalProductList = new ArrayList<>(homePage.getProductList());
        List<WebElement> sortedList = homePage.sortProductNamesZToA();
        List<String> sortedOriginalProductTitleList = originalProductList.stream().map(originalProduct -> originalProduct.findElements(By.className("inventory_item_name")).get(0).getText()).sorted(Comparator.reverseOrder()).toList();
        List<String> sortedProductTitleList =sortedList.stream().map(originalProduct -> originalProduct.findElements(By.className("inventory_item_name")).get(0).getText()).toList();

        Assert.assertEquals(sortedProductTitleList, sortedOriginalProductTitleList, "Product Names not sorting correctly!");
    }

    @Test
    public void sortProductNamesAToZ() {
        loginPage.LoginValidData();
        // Since product list is *pass-by-reference* we need to create a copy of that list and paste it into a new list called original product list
        List<WebElement> originalProductList = new ArrayList<>(homePage.getProductList());
        List<WebElement> sortedList = homePage.sortProductNamesAToZ();
        List<String> sortedOriginalProductTitleList = originalProductList.stream().map(originalProduct -> originalProduct.findElements(By.className("inventory_item_name")).get(0).getText()).sorted().toList();
        List<String> sortedProductTitleList =sortedList.stream().map(originalProduct -> originalProduct.findElements(By.className("inventory_item_name")).get(0).getText()).toList();

        Assert.assertEquals(sortedProductTitleList, sortedOriginalProductTitleList, "Product Names not sorting correctly!");
    }

    @Test
    public void sortProductPriceLowToHigh() {
        loginPage.LoginValidData();
        // Since product list is *pass-by-reference* we need to create a copy of that list and paste it into a new list called original product list
        List<WebElement> originalProductList = new ArrayList<>(homePage.getProductList());
        List<WebElement> sortedList = homePage.sortProductPriceLowToHigh();
        List<Double> sortedOriginalProductTitleList = originalProductList
                .stream()
                .map(originalProduct -> originalProduct.findElements(By.className("inventory_item_price")).get(0).getText())
                .map(price -> price.substring(1))
                .map(Double::valueOf)
                .sorted()
                .toList();

        List<Double> sortedProductTitleList = sortedList
                .stream()
                .map(originalProduct -> originalProduct.findElements(By.className("inventory_item_price")).get(0).getText())
                .map(price -> price.substring(1))
                .map(Double::valueOf)
                .toList();

        Assert.assertEquals(sortedProductTitleList, sortedOriginalProductTitleList, "Product Price not sorting correctly!");
    }

    @Test
    public void sortProductPriceHighToLow() {
        loginPage.LoginValidData();
        // Since product list is *pass-by-reference* we need to create a copy of that list and paste it into a new list called original product list
        List<WebElement> originalProductList = new ArrayList<>(homePage.getProductList());
        List<WebElement> sortedList = homePage.sortProductPriceHighToLow();
        List<Double> sortedOriginalProductTitleList = originalProductList
                .stream()
                .map(originalProduct -> originalProduct.findElements(By.className("inventory_item_price")).get(0).getText())
                .map(price -> price.substring(1))
                .map(Double::valueOf)
                .sorted(Comparator.reverseOrder())
                .toList();

        List<Double> sortedProductTitleList = sortedList
                .stream()
                .map(originalProduct -> originalProduct.findElements(By.className("inventory_item_price")).get(0).getText())
                .map(price -> price.substring(1))
                .map(Double::valueOf)
                .toList();

        Assert.assertEquals(sortedProductTitleList, sortedOriginalProductTitleList, "Product Price not sorting correctly!");
    }
}
