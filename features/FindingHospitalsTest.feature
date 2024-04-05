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

Feature: Finding hospitals

  Scenario: Fetching doctors details
    Given navigate to practo
    And enter the search fields
    When apply all the filters
    Then get the details of first five doctors
    
  #Scenario: Fetching surgeries
    #And navigate to surgeries
    #And get all the surgeries list
    
  #Scenario: Verifying the Thankyou message after applying for a demo 
    #And navigate to form filling page
    #And fill the invalid details
    #Then validate if Schedule a demo button is not disabled 
    #When fill the valid details
    #Then validate if Schedule a demo button is disabled 
    #And verify the Thankyou msg
