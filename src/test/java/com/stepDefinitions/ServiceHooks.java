package com.stepDefinitions;

import com.Models.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ServiceHooks {

    TestBase testBase;

    @Before
    public void setup() {
        testBase = new TestBase();
        System.out.println("Browser starts");
    }

    @After
    public void endTest() {
        testBase.driver.quit();
    }


}
