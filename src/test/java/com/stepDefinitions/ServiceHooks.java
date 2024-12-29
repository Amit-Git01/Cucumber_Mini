package com.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ServiceHooks {

    TestBase testBase;

    @Before
    public void setup() {
        testBase = new TestBase();
        testBase.createLocalDriver();
        System.out.println("Browser starts");
    }

    @After
    public void endTest() {
        testBase.driver.quit();
    }


}
