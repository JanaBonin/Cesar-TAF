package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import selenium_pages.Page_GoogleHomepage;
import io.cucumber.java.en.Then;
import selenium_pages.Page_base;

public class StepDefinitionStandard {
	
	Page_base standard = new Page_base();
	
	@Given("Open Firefox and go to {string}")
	public void open_Firefox_and_go_to(String Url) {
	    standard.openFirefoxWindow();
	    standard.goToUrl(Url);
	}
	
	@Given("Open Chrome and go to {string}")
	public void open_Chrome_and_go_to(String Url) {
	    standard.openChromeWindow();
	    standard.goToUrl(Url);
	}
	
	@Then("Close browser")
	public void close_Browser() {
		standard.closeWindow();
	}
	
	
}