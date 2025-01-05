package com.Models;

import com.Utilities.Locators;
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
        Thread.sleep(2000);
        driver.findElement(plusBtn).click();
    }

    private void clickOnMinusBtn() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(minusBtn).click();
    }

    public void addQuantity(int quantity) throws InterruptedException {

//        for(int i=1; i < quantity; i++) {
            clickOnPlusBtn();
//        }
        Thread.sleep(8000);
    }

    public void removeQuantity(int quantity) throws InterruptedException {

//        for(int i=1; i < quantity; i++) {
            clickOnMinusBtn();
//        }
        Thread.sleep(5000);
    }

    public void printSubTotal() throws InterruptedException {
        Thread.sleep(2000);
        String total = driver.findElement(subTotal).getText();
        System.out.println("*****************Displayed Total price**************");
        System.out.println(total);
    }

    public void verfiyProceedToBuy() {
        boolean isVisible = driver.findElement(proceedToBuy).isDisplayed();
        Assert.assertTrue(isVisible);
    }
}
