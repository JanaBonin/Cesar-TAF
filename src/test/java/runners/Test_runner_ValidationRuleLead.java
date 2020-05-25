package runners;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import sendingSalesforce.SendingJSONResult;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Feature/ValidationRuleLeadTestSHORT.feature", glue="steps",strict = true,
					plugin= {"json:target/cucumber.json",
							 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
					})

public class Test_runner_ValidationRuleLead {
	
	@AfterClass
	public static void sendingJSON() {
		SendingJSONResult send = new SendingJSONResult();
		send.sendJSONFile("./target/cucumber.json");
	}
}

