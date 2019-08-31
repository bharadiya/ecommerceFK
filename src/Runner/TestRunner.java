package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/Features/Login.Feature", glue = { "TestCases" }, tags = { "@Login" })
public class TestRunner {

}
