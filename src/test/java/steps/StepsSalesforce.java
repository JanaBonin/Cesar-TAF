package steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import selenium_pages.Page_SF_Lead;
import selenium_pages.Page_SF_Login;
import selenium_pages.Page_base;
import java.util.ArrayList;


public class StepsSalesforce {
	
	private Page_SF_Login standard = new Page_SF_Login();
	
	@Given ("Make login on SalesForce with Chrome")
	public void make_login_Chrome() {
		standard.openChromeWindow();
		standard.makeLogin();
	}
	
	@Given ("Make login on SalesForce with Firefox")
	public void make_login_Firefox() {
		standard.openFirefoxWindow();
		standard.makeLogin();
	}
	
	
	@Given("Go to {string} Page")
	public void go_to_Page(String Page) {
	    standard.goToPage(Page);
	}
	
	
	@Given("Update {string} name of record {string}")
	public void update_name_of_lead(String entityObject, String searchText, DataTable dataTable) {
	   List<Map<String,String>> value = dataTable.asMaps();
		if(entityObject.equalsIgnoreCase("Lead")) {
			standard.update("Leads",searchText,value);
		}
		if(entityObject.equalsIgnoreCase("Account")) {
			standard.update("Accounts",searchText,value);
		}
		
	}
	
	/*
	@Then("Update {string} name of record {string}")
	public void Then_update_name_of_lead(String entityObject, String searchText, DataTable dataTable) {
	   update_name_of_lead(entityObject,searchText,dataTable);
	}
	*/
	@Then("Check insert successfully")
	public void check_insert_successfully() {
		if(!standard.checkIfObjectCreated())
			Assert.fail("Object not created");
	}
	
	@Then("Check insert unsuccessfully")
	public void check_insert_unsuccessfully() {
		if(!standard.checkIfObjectNotCreated())
			Assert.fail("Object created");
	}
	
	@Then("Check if the {string} , {string} exist in the search page")
	public void check_insert(String obj,String text) {
		if(standard.search(text,obj)== null) {
			Assert.fail("Object "+obj+" : "+text+" not found");
		}
	}
	
	@Then("Check if the {string} , {string} doesn't exist in the search page")
	public void check_insert_doesnt(String obj,String text) {
		if(standard.search(text,obj)!= null) {
			Assert.fail("Object "+obj+" : "+text+" not found");
		}
	}

}
