package com.Models;

import com.Managers.AllManagers;
import com.Utilities.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {

    public WebDriver driver;

    public HomePage( WebDriver driver) {
        this.driver = driver;
    }

    private final By signInLink = Locators.getLocator("homePage", "signInLink");
    private final By verifyName = Locators.getLocator("homePage", "verifyName");
   private final By searchBox = Locators.getLocator("homePage", "searchBox");

    public void openApplication() throws InterruptedException {
        driver.get(AllManagers.getUrl());
        Thread.sleep(5000);
    }

    public SignInPage clickOnSignIn() {
        driver.findElement(signInLink).click();
        return new SignInPage(driver);
    }

    public void verifyHomePage(String name) throws InterruptedException {
        Thread.sleep(2000);
        boolean actual = driver.findElement(verifyName).getText().contains(name);
        Assert.assertTrue(actual);
    }

    public SearchProductPage searchProduct(String product) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(searchBox).sendKeys(product, Keys.ENTER);
        return new SearchProductPage(driver);
    }

}
