package com.stepDefinitions;

import com.Constants.DriverType;
import com.Managers.AllManagers;
import com.Reader.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

    public static WebDriver driver;
    private  final ConfigFileReader reader = new ConfigFileReader();

    public  WebDriver createLocalDriver() {
        DriverType driverType = reader.getBrowserType();
        switch (driverType) {
            case CHROME -> driver = new ChromeDriver();
            case EDGE -> driver = new EdgeDriver();
            case FIREFOX -> driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        return driver;
    }
}
