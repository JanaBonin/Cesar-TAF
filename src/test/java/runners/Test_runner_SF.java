package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Feature/LoginTest.feature", glue="steps",strict = true,
					plugin= {"json:target/cucumber.json"
					})
public class Test_runner_SF {
	
}

//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}