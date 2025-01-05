package com.Models;

import com.Utilities.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignInPage {

    public WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By emailInput = Locators.getLocator("homePage", "emailInput");
    private final By continueBtn = Locators.getLocator("homePage", "continueBtn");
    private final By passwordInput = Locators.getLocator("homePage", "passwordInput");
    private final By signInLogo = Locators.getLocator("homePage", "signInLogo");
    private final By signInBtn = Locators.getLocator("homePage", "signInBtn");

    public void verifySignPage() {
        boolean bol = driver.findElement(signInLogo).isDisplayed();
        Assert.assertTrue(bol);
    }

    public void enterEmail(String email) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(emailInput).sendKeys(email);
    }

    public void clickOnContinueBtn() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(continueBtn).click();
    }

    public void enterPwd(String pwd) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(passwordInput).sendKeys(pwd);
    }

    public HomePage clickOnSignInBtn() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(signInBtn).click();
        return new HomePage(driver);
    }
}
