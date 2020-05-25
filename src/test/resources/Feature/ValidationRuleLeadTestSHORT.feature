Feature: Test validation rule on phone field

Background:
	Given open Chrome and go to "https://login.salesforce.com"
	When enter userID as "sfdevopsrpaframework@digita.com"
	And enter password as "sfdevopsezn88"
	Then check login successfully

Scenario: Check validation rule with correct Phone number (+393348494751)
	Given Go to "Lead" Page
	When Insert "Lead" with this value for the field
		|Field		|Value					|
		|First name	|Test					|
		|Last name 	|1						|
		|Email		|desposito@deloitte.it	|
		|Phone		|+393348494752			|
		|Company	|Deloitte				|
		|Lead source|Web					|
		|Lead status|Working - Contacted	|
		|Rating		|Cold					|
		|Description|Test correct			|
	Then Check insert new "Lead" successfully
