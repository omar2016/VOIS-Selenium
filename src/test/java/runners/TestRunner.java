package runners;

import io.cucumber.junit.CucumberOptions;
import tests.TestBase;


    @CucumberOptions(features="src/test/java/feature"
            ,glue = {"Steps"}
            ,monochrome=true
            ,plugin = {"pretty","html:test-output/cucumber-report"})
    public class TestRunner extends TestBase {
}
