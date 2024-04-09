#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Taking Demo

@regression
Scenario: Verifying the schedule demo button
		Given navigate to practo
    When clicked on for Corporates 
		Then health and wellnes plans should be clicked
    When filled in the invalid details in the form
    Then validate if schedule a demo button is disabled

@regression
Scenario: Verifying the Thankyou message after applying for a demo 
	  Given navigate to practo
	  When clicked on for Corporates 
		Then health and wellnes plans should be clicked   
    When filled in the valid details in the form
    Then validate if Schedule a demo button is not disabled 
    And verify the Thankyou msg
