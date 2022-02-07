package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/resources/features/HunterAPILeads.feature",
glue = "stepDefinitions",
tags = "Ct02",
plugin = {"pretty","html:target/report-html.html", "json:target/report.json"},
monochrome = true)
public class RunnerAPI {
	
}
