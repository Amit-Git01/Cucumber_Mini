package com.Managers;

import com.Constants.DriverType;
import com.Reader.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AllManagers {

    public WebDriver driver;
    private final ConfigFileReader reader = new ConfigFileReader();
    public AllManagers() {
    }

    public WebDriver createLocalDriver() {
        DriverType driverType = reader.getBrowserType();
        switch (driverType) {
            case CHROME -> driver = new ChromeDriver();
            case EDGE -> driver = new EdgeDriver();
            case FIREFOX -> driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        return driver;
    }

    public String getUrl() {
        return reader.getURL();
    }

    public long getTimeout() {
        return reader.getTimeout();
    }


}
