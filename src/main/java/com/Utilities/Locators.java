package com.Utilities;

import com.Constants.LocatorType;
import com.Reader.YmlReader;
import org.openqa.selenium.By;

public class Locators {

    private static final YmlReader ymlReader = new YmlReader();

    private static By by;

    public Locators() {
    }

    public static By getLocator(String page, String elementName) {

        LocatorType locatorType = ymlReader.getLocatorType(page, elementName);
        String value = ymlReader.getLocatorValue(page, elementName);

        return switch (locatorType) {
            case ID -> by = By.id(value);
            case XPATH -> by = By.xpath(value);
            case TAG_NAME -> by = By.tagName(value);
            case NAME -> by = By.name(value);
            case LINK_TEXT -> by = By.linkText(value);
            case CSS_SELECTOR -> by = By.cssSelector(value);
            case CLASS_NAME -> by = By.className(value);
            case PARTIAL_LINK_TEXT -> by = By.partialLinkText(value);
        };

    }
}
