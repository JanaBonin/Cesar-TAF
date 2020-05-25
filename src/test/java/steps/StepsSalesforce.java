package steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import selenium_pages.Page_SF_Lead;
import selenium_pages.Page_SF;
import selenium_pages.Page_base;
import sendingSalesforce.SetProfileUser;

import java.util.ArrayList;


public class StepsSalesforce {
	
	private Page_SF standard = new Page_SF();
	
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
	
	@Given ("Make login with {string} with Chrome")
	public void make_login_other_User_Chrome(String Name) {
		standard.openChromeWindow();
		standard.makeLoginOtherUser(Name);
	}
	
	
	@Given ("Make login with {string} with Firefox")
	public void make_login_other_User_Firefox(String Name) {
		standard.openFirefoxWindow();
		standard.makeLoginOtherUser(Name);
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
	
	@Given("Insert {string} with this value for the field")
	public void insert_string_Value(String entity, DataTable dataTable) {
		List<Map<String,String>> value = dataTable.asMaps();
		 standard.newRecord(entity, value);
		 standard.saveButton();	 
	}
	
	
	@Given("Go to {string} page and open {string}")
	public void go_to_page_and_open(String object, String record) {
	    standard.goToPage(object);
	    standard.selectRecord(record);
	    standard.goToDetails();
	}
	
	/*
	@Then("Update {string} name of record {string}")
	public void Then_update_name_of_lead(String entityObject, String searchText, DataTable dataTable) {
	   update_name_of_lead(entityObject,searchText,dataTable);
	}
	*/
	@Then("Check insert successfully")
	public void check_insert_successfully() {
		if(!standard.checkIfRecordCreated())
			Assert.fail("Object not created");
	}
	
	@Then("Check insert unsuccessfully")
	public void check_insert_unsuccessfully() {
		if(standard.checkIfRecordCreated())
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
			Assert.fail("Object "+obj+" : "+text+" found");
		}
	}
	
	@Then("Check if the label {string} exists")
	public void check_if_the_label_exists(String label) {
	    boolean var = standard.findLabel(label);
	    if (!var) {
	    	Assert.fail("Label not found");
	    }
	}
	
	@Then("Check if the label {string} does not exists")
	public void check_if_the_label_doesnt_exists(String label) {
	    boolean var = standard.findLabel(label);
	    if (var) {
	    	Assert.fail("Label found");
	    }
	}
	
	@Given("Switch user to {string}")
	public void switch_user_to(String username, String profile) {
		SetProfileUser send = new SetProfileUser(username,profile);
	}

}
