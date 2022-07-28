#Exercize for Webdriver experience
# Author: Anna Verkhovskaya

@webdriver @regression
Feature: Exercize for Webdriver experience

  Background:
    Given I navigate "quote"

  @webdriver1
  Scenario: Open URL using site name
      #Given I navigate "quote"
    And I print page details

  @webdriver2
  Scenario: Email field verification
    When I type "abc" into email field
    And I click Submit button
    Then error message "Please enter a valid email address." should be displayed

  @webdriver3
  Scenario: Full name validation
    When Click on Name field
    Then I open Name dialog window
    Then I type "A" as First Name "S" as Middle Name "D" as Last Name and validate the Full name is "A S D"