Feature: Test Process Builder on Lead

Background:
	Given Make login on SalesForce with Chrome

Scenario: Check the if the lead's process builder start
	Given Update "Lead" name of record "Giuseppe Ciaravolo"
			|Field 		|Value 	|Type		|
			|Rating 	|Hot	|ComboBox 	|
	Then  Check if the "Contacts" , "CanarinoStudio" exist in the search page 
	And   Check if the "Accounts" , "Antonio Canarino" exist in the search page

Scenario: Check the if the lead's process builder start
	Given Update "Lead" name of record "Giuseppe Ciaravolo 1"
			|Field 		|Value 	|Type		|
			|Rating 	|Cold	|ComboBox 	|
	Then  Check if the "Contacts" , "CanarinoStudio" doesn't exist in the search page 
	And   Check if the "Accounts" , "Antonio Canarino" doesn't exist in the search page
	