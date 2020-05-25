Feature: Test of login on SalesForce
 
Scenario: Go to salesforce login and make login
	Given Open Chrome and go to "https://login.salesforce.com/"
	When Enter userID as "sfdevopsrpaframework@digita.com"
	And Enter password as "sfdevopsezn88"
	Then Check login successfully
	And Close browser
