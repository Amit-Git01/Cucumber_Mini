package com.Models;

import com.Utilities.Locators;
import com.Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class SearchProductPage {

    public WebDriver driver;

    public SearchProductPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By appleWatchList = Locators.getLocator("searchPage", "appleWatchList");
    private final By iphoneList = Locators.getLocator("searchPage", "iphoneList");
    private final By addToCartBtn = Locators.getLocator("productPage", "addToCartBtn");
    private final By cartBtn = Locators.getLocator("productPage", "cartBtn");

    public CartPage addWatch() throws InterruptedException {
        Wait.waitForSeconds(3);
        String parent = driver.getWindowHandle();
        List<WebElement> watches = driver.findElements(appleWatchList);
        for(int i = 0; i < watches.size(); i++) {
            String text = watches.get(i).getText();
            if(text.contains("Apple Watch Series 10 [GPS 42 mm] Smartwatch with Jet Black Aluminium Case with Black Sport Band - S/M. Fitness Tracker, ECG App, Always-On Retina Display, Water Resistant")) {
                watches.get(i).click();
                break;
            }
        }

        Set<String> windows = driver.getWindowHandles();
        for(String window : windows) {
            if(!window.equals(parent)) {
                driver.switchTo().window(window);
                break;
            }
        }

        Wait.untilElementIsVisible(driver, addToCartBtn, 3);
        driver.findElement(addToCartBtn).click();

        Wait.waitForSeconds(3);
        clickOnCartBtn();

        return new CartPage(driver);
    }

    public CartPage addPhone() throws InterruptedException {
        Wait.waitForSeconds(3);
        String parent = driver.getWindowHandle();
        List<WebElement> phones = driver.findElements(iphoneList);
        for(int i = 0; i < phones.size(); i++) {
            String text = phones.get(i).getText();
            if(text.contains("Apple iPhone 15 (128 GB) - Black")) {
                phones.get(i).click();
                break;
            }
        }

        Set<String> windows = driver.getWindowHandles();
        for(String window : windows) {
            if(!window.equals(parent)) {
                driver.switchTo().window(window);
                String title = driver.getTitle();
                if (title != null && title.equals("Apple iPhone 15 (128 GB) - Black : Amazon.in: Electronics")) {
                    break;
                }
            }
        }
        Wait.untilElementIsVisible(driver, addToCartBtn, 3);
        driver.findElement(addToCartBtn).click();

        Wait.waitForSeconds(3);
        clickOnCartBtn();

        return new CartPage(driver);

    }

    private void clickOnCartBtn() throws InterruptedException {
        Wait.untilElementIsVisible(driver, cartBtn, 3);
        driver.findElement(cartBtn).click();
    }


}
