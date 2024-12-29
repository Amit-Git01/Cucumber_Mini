package com.tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/features",
        glue = "com.stepDefinitions",
        plugin = {"pretty"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
