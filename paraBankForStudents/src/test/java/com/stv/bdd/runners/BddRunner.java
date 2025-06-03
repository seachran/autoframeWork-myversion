package com.stv.bdd.runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = "src/test/java/com/stv/bdd/features",
        glue = "com.stv.bdd.steps",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class BddRunner extends AbstractTestNGCucumberTests {
}
