package Testrunnerexam;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Exam"
		, glue = "Stepdefinitionexam"
		, plugin = { "json:target/cucumber.json" }
		,tags = {"@SmokeTest" }
		)
public class Runnerexam {

}
