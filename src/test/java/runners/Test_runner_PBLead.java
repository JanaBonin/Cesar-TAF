package runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.gherkin.model.Scenario;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Feature/ProcessBuilderTest.feature", glue="steps",strict = true,
					plugin= {"json:target/cucumberPBLeadTest.json",
							 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					})

public class Test_runner_PBLead {
	
}