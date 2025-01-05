package com.Models;

import com.Managers.AllManagers;
import com.Utilities.Locators;
import com.Utilities.Wait;
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
    }

    public SignInPage clickOnSignIn() {
        Wait.untilElementIsVisible(driver, signInLink, 3);
        driver.findElement(signInLink).click();
        return new SignInPage(driver);
    }

    public void verifyHomePage(String name) throws InterruptedException {
        Wait.untilElementIsVisible(driver, verifyName, 3);
        boolean actual = driver.findElement(verifyName).getText().contains(name);
        Assert.assertTrue(actual);
    }

    public SearchProductPage searchProduct(String product) throws InterruptedException {
        Wait.untilElementIsVisible(driver, searchBox, 3);
        driver.findElement(searchBox).sendKeys(product, Keys.ENTER);
        return new SearchProductPage(driver);
    }

}
