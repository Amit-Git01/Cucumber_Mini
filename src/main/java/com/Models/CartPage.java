package com.Models;

import com.Utilities.Locators;
import com.Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage {

    public WebDriver driver;

    public CartPage( WebDriver driver) {
        this.driver = driver;
    }

    private final By plusBtn = Locators.getLocator("cartPage", "plusBtn");
    private final By minusBtn = Locators.getLocator("cartPage", "minusBtn");
    private final By subTotal = Locators.getLocator("cartPage", "subTotal");
    private final By proceedToBuy = Locators.getLocator("cartPage", "proceedToBuy");

    private void clickOnPlusBtn() throws InterruptedException {
        Wait.untilElementIsVisible(driver, plusBtn, 3);
        driver.findElement(plusBtn).click();
    }

    private void clickOnMinusBtn() throws InterruptedException {
        Wait.untilElementIsVisible(driver, minusBtn, 3);
        driver.findElement(minusBtn).click();
    }

    public void addQuantity(int quantity) throws InterruptedException {
        clickOnPlusBtn();
        Wait.waitForSeconds(3);
    }

    public void removeQuantity(int quantity) throws InterruptedException {
        clickOnMinusBtn();
        Wait.waitForSeconds(3);
    }

    public void printSubTotal() throws InterruptedException {
        Wait.untilElementIsVisible(driver, subTotal, 3);
        String total = driver.findElement(subTotal).getText();
        System.out.println("*****************Displayed Total price**************");
        System.out.println(total);
    }

    public void verifyProceedToBuy() {
        boolean isVisible = driver.findElement(proceedToBuy).isDisplayed();
        Assert.assertTrue(isVisible);
    }
}
