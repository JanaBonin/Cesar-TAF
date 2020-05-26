Feature: Test visibility

Scenario: Verify fields visibility in Support Profile
	Given Switch "sftestautomation2@digita.com" to "Custom: Support Profile"
	And   Make login with "secondUser" with Chrome
	When  Go to "Account" page and open "Arcella S.r.l."
	Then  Check if "Employees" label does not exist
	And   Check if "Annual Revenue" label does not exist

Scenario: Verify fields visibility in Sales Profile
	Given Switch "sftestautomation2@digita.com" to "Custom: Sales Profile"
	And   Make login with "secondUser" with Chrome
	When  Go to "Account" page and open "Arcella S.r.l."
	Then  Check if "Employees" label exists
	And   Check if "Annual Revenue" label exists

	
