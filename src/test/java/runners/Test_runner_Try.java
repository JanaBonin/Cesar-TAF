package runners;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Feature/try.feature", glue="steps",strict = true,
					plugin= {"json:target/cucumber.json"
					})


public class Test_runner_Try {
	
	@AfterClass
    public static void teardown() {
		
    }
}
