package com.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {

    public static void untilElementIsVisible(WebDriver driver, By element, int timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds((long)timeoutInSeconds))
                .until(ExpectedConditions.visibilityOf(driver.findElement(element)));
    }

    public static void waitForSeconds(int sec) throws InterruptedException {
        Thread.sleep(Duration.ofSeconds((long)sec));
    }
}
