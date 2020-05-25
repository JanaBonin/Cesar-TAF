package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import selenium_pages.Page_GoogleHomepage;
import io.cucumber.java.en.Then;

public class StepDefinition {
	
	Page_GoogleHomepage googleHomepage = new Page_GoogleHomepage();
	
	@Given("I launch Chrome browser")
	public void i_launch_Chrome_browser() {
		googleHomepage.lauchChromeBrowser();
	}
	
	@Given("I launch Firefox browser")
	public void i_launch_Firefox_browser() {
		googleHomepage.launchFirefoxBrowser();
	}

	@When("I open Google Homepage")
	public void i_open_Google_Homepage() {
		googleHomepage.openGoogleURL();
	}
	
	@Then("I search for {string} on Google")
	public void i_search_for_on_Google(String stringa) {
		googleHomepage.searchElementGoogleHomepage(stringa);
	}
	
	@Then("I verify that the page displays search text box")
	public void i_verify_that_the_page_displays_search_text_box() {
		googleHomepage.checkSearchBoxIsDisplayed();
	}

	@Then("the page displays Google Search button")
	public void the_page_displays_Google_Search_button() {
		googleHomepage.checkGoogleSearchButtonIsDisplayed();
	}

	@Then("the page displays Im Feeling Lucky button")
	public void the_page_displays_Im_Feeling_Lucky_button() {
		googleHomepage.checkImFeelingLuckyButtonIsDisplayed();
	}
	
	@Then("Close the browser")
	public void close_the_browser() {
		googleHomepage.closeWindow();
	}
}