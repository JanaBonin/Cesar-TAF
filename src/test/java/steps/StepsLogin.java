package steps;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import selenium_pages.Page_SF_Login;


public class StepsLogin {
	
	Page_SF_Login sfpage = new Page_SF_Login();
	
	@Given("open Firefox and go to {string}")
	public void open_Firefox_and_go_to(String Url) {
	    sfpage.openFirefoxWindow();
	    sfpage.goToUrl(Url);
	}
	@Given("open Chrome and go to {string}")
	public void open_Chrome_and_go_to(String Url) {
	    sfpage.openChromeWindow();
	    sfpage.goToUrl(Url);
	}
	
	@When("enter userID as {string}")
	public void enter_userID_as(String testo) {
	    sfpage.insertUser(testo);
	}
	
	@When("enter password as {string}")
	public void enter_password_as(String testo) {
		sfpage.insertPassword(testo);
	}
	
	@Then("^check login (successfully|not successfully)$")
	public void check_login(String caseof) {
		sfpage.clickAccess();
		if((sfpage.checkLogin()) && (caseof.equalsIgnoreCase("not successfully"))) {
			Assert.fail();
	    }
		if(!(sfpage.checkLogin()) && (caseof.equalsIgnoreCase("successfully"))) {
			Assert.fail();
	    }
	    //sfpage.closeWindow();
	}
}
