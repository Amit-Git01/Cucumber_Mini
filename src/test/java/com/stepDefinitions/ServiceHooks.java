package com.stepDefinitions;

import com.Models.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class ServiceHooks {

    TestBase testBase;
    WebDriver driver;

    @Before
    public void setup() {
        testBase = new TestBase();
        driver = testBase.getDriver();
        System.out.println("******* Browser is starting *********");
    }

    @After
    public void endTest() {
        if(driver != null) {
            driver.quit();
            System.out.println("******* Browser is stopping *********");
        }
    }


}
