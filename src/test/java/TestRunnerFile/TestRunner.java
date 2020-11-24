package TestRunnerFile;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)

@CucumberOptions
(features = "src\\test\\java\\feature\\Test_Scenario.feature",
glue = {"StepDefinitionsFiles"})



public class TestRunner {

}
