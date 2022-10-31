package config;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/resources/features",
        glue = "step_definition",
        plugin = { "html:target/cucumber-report/testreport.html"})
public class RunCucumberTest {

}