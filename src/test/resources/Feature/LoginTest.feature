Feature: Test SalesForce login

Scenario: Check login on SF org with valid credentials
Given open Chrome and go to "https://login.salesforce.com"
When enter userID as "sfdevopsrpaframework@digita.com"
And enter password as "sfdevopsezn88"
Then check login successfully

Scenario: Check login on SF org with not valid credentials
Given open Chrome and go to "https://login.salesforce.com"
When enter userID as "2022"
And enter password as "test"
Then check login not successfully