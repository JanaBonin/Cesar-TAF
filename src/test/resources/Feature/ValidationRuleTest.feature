Feature: Test validation rule on phone field

Background:
	Given Make login on SalesForce with Firefox

Scenario: Check validation rule with correct phone number (+393348494751)
	Given Insert "Lead" with this value for the field
		|Field		|Value					|Type		|
		|First name	|Vincenzo				|Text		|
		|Last name 	|Lucignano				|Text		|
		|Email		|vl93@hotmail.it		|Text		|
		|Phone		|+393348494751			|Text		|
		|Company	|Digita					|Text		|
		|Lead source|Web					|ComboBox	|
		|Lead status|Working - Contacted	|ComboBox	|
		|Rating		|Cold					|ComboBox	|
		|Description|Test correct			|TextArea	|
	Then Check insert successfully
	

	
Scenario: Check validation rule with a short phone number (+39334849475)
	Given Insert "Lead" with this value for the field
		|Field		|Value					|Type 		|
		|First name	|Giuseppe				|Text		|
		|Last name 	|Ciaravolo				|Text		|
		|Email		|gc@hotmail.it			|Text		|
		|Phone		|+39334849475			|Text		|
		|Company	|Digita					|Text		|
		|Lead source|Web					|ComboBox	|
		|Lead status|Working - Contacted	|ComboBox	|
		|Rating		|Cold					|ComboBox	|
		|Description|Test Uncorrect			|TextArea	|
	Then Check insert unsuccessfully
	
Scenario: Check validation rule with a not Italian phone number(+273348494751)
	Given Insert "Lead" with this value for the field
		|Field		|Value					|Type		|
		|First name	|Giuseppe				|Text		|
		|Last name 	|Ciaravolo				|Text		|
		|Email		|gc@hotmail.com			|Text		|
		|Phone		|+273348494751			|Text 		|
		|Company	|Digita					|Text		|
		|Lead source|Web					|ComboBox	|
		|Lead status|Working - Contacted	|ComboBox	|
		|Rating		|Cold					|ComboBox	|
		|Description|Test Uncorrect			|TextArea	|
	Then Check insert unsuccessfully
	
Scenario: Check validation rule with a short and not Italian phone number(+27334849475)
	Given Insert "Lead" with this value for the field
		|Field		|Value					|Type		|
		|First name	|Giuseppe				|Text		|
		|Last name 	|Ciaravolo				|Text		|
		|Email		|gc@hotmail.it			|Text		|
		|Phone		|+27334849475			|Text		|
		|Company	|Digita					|Text		|
		|Lead source|Web					|ComboBox	|
		|Lead status|Working - Contacted	|ComboBox	|
		|Rating		|Cold					|ComboBox	|
		|Description|Test Uncorrect			|TextArea	|
	Then Check insert unsuccessfully