package com.Utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {

    public static void untilElementIsVisible(WebDriver driver, WebElement element, Long timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForMinute(WebDriver driver, WebElement element, Long time) {

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMinutes(time))
                .pollingEvery(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class);

        wait.until(driver1 -> {
            wait.withTimeout(Duration.ofSeconds(10));
            return true;
        });

    }
}
