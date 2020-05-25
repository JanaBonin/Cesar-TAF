package steps;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import selenium_pages.Page_SF;


public class StepsLoginSalesforce {
	
	Page_SF sfpage = new Page_SF();
	
	@When("Enter userID as {string}")
	public void enter_userID_as(String testo) {
	    sfpage.insertUser(testo);
	}
	
	@When("Enter password as {string}")
	public void enter_password_as(String testo) {
		sfpage.insertPassword(testo);
	}
	
	@Then("^Check login (successfully|not successfully)$")
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
