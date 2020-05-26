Feature: Test on Formula Field

Background: Login to SF 
	Given Make login on SalesForce with Chrome

Scenario: Check Formula Field Amount < 50000, Small Opportunity
    Given Insert "Opportunity" with this value for the field
    		|Field		      |Value				 |Type		|
    		|Opportunity Name |Janaina Bonin 		 |Text		|
			|Account Name     |Deloitte  			 |Wrapper	|
			|Amount       	  |30000        		 |Text  	|
			|Close Date    	  |25/06/2020	  		 |Text  	|
			|Stage      	  |Negotiation/Review	 |Combobox 	|
			
	When Open "Janaina Bonin" in "Opportunities"
	Then Check if "Opportunity Level" is "Small Opportunity"

Scenario: Check Formula Field 50000< amount <100000, Medium Opportunity
    Given Insert "Opportunity" with this value for the field
    		|Field		      |Value				 |Type		|
    		|Opportunity Name |Donatella Carrillo	 |Text		|
			|Account Name     |Digiters  			 |Wrapper	|
			|Amount       	  |60000        		 |Text  	|
			|Close Date    	  |26/06/2020	  		 |Text  	|
			|Stage      	  |Prospecting      	 |Combobox 	|
			
	When Open "Donatella Carrillo" in "Opportunities"
	Then Check if "Opportunity Level" is "Medium Opportunity"

Scenario: Check Formula Field Amount > 100000, Best Opportunity
    Given Insert "Opportunity" with this value for the field
    		|Field		      |Value				 |Type		|
    		|Opportunity Name |Benedetta Arcella	 |Text		|
			|Account Name     |Federico II 			 |Wrapper	|
			|Amount       	  |250000  	        	 |Text  	|
			|Close Date    	  |26/06/2020	  		 |Text  	|
			|Stage      	  |Prospecting      	 |Combobox 	|
			
	When Open "Benedetta Arcella" in "Opportunities"
	Then Check if "Opportunity Level" is "Best Opportunity"
	
Scenario: Check Formula Field Amount < 50000, is not Best Opportunity
    Given Insert "Opportunity" with this value for the field
    		|Field		      |Value				 |Type		|
    		|Opportunity Name |Michele Canarino  	 |Text		|
			|Account Name     |CanarinoStudio		 |Wrapper	|
			|Amount       	  |15000  	        	 |Text  	|
			|Close Date    	  |26/06/2020	  		 |Text  	|
			|Stage      	  |Prospecting      	 |Combobox 	|
			
	When Open "Michele Canarino" in "Opportunities"
	Then Check if "Opportunity Level" is not "Best Opportunity"
