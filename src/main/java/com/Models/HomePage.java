package com.Models;

import com.Managers.AllManagers;
import com.Utilities.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {

    public WebDriver driver;

    public HomePage( WebDriver driver) {
        this.driver = driver;
    }

    private final By signInLink = Locators.getLocator("homePage", "signInLink");

    public void openApplication() throws InterruptedException {
        driver.get(AllManagers.getUrl());
        Thread.sleep(5000);
    }

    public SignInPage clickOnSignIn() {
        driver.findElement(signInLink).click();
        return new SignInPage(driver);
    }





}
