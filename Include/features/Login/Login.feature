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
Feature: Login

  Scenario Outline: Login with invalid credentials
    Given I navigate to orrage HRM page
    When I enter invalid username "<un>"
    And I enter invalid password "<pw>"
    And I click on login button
    Then System should display error message "<error_msg>"

    Examples: 
      | un    | pw   | error_msg           |
      | name1 |   35 | Invalid identifiers |
      | name2 | 3247 | Invalid identifiers |
