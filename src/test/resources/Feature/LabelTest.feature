Feature: Test existence of label
Unit Test

Background: Log into SalesForce
	Given Make login on SalesForce with Chrome

Scenario: Check existence of label "Personal Email Address"
	Given Go to "Contact" page and open "Domenico Esposito"
	Then Check if the label "Personal Email Address" exists
	And Close browser