package com.dlg.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty"
        },
        features = "@target/rerun.txt",
        glue = "com/dlg/step_definitions"

)
public class FailedTestRunner {
}
