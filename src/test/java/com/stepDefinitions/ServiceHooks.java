package com.stepDefinitions;

import com.Models.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ServiceHooks {

    TestBase testBase;

    @Before
    public void setup() {
        testBase = new TestBase();
        testBase.getDriver();
        System.out.println("Browser starts");
    }

    @After
    public void endTest() {
        if(TestBase.driver != null) {
            TestBase.driver.quit();
        }
    }


}
