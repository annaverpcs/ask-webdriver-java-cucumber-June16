# Test Automation Exercise - Cucumber
# https://jira.portnov.com/browse/ACB-8
# Author : Anna Verkhovskaya

@cucumber
Feature: Quote Test Scenarios
  # Validate responsive UI behavior
  @cucumber1
  Scenario: Validate responsive UI behavior
    Given I open url "https://skryabin.com/market/quote.html"
    Then I should see page title as "Get a Quote"
    When I resize window to 1920 and 1080
    Then element with xpath "//b[@id='location']" should be displayed
    Then element with xpath "//b[@id='location']" should contain text "Los Altos, CA 94022"
    When I resize window to 1440 and 900
    Then element with xpath "//b[@id='location']" should be displayed
    Then element with xpath "//b[@id='location']" should contain text "Los Altos, CA 94022"
    When I resize window to 375 and 667
    Then element with xpath "//b[@id='location']" should not be displayed

  #Fill out and validate “Username” field. Validate minimal “Username” field length requirement as 2 characters
  @cucumber2
  Scenario: Verify Username field
    Given I open url "https://skryabin.com/market/quote.html"
    Then I should see page title as "Get a Quote"
    When I type "A" into element with xpath "//input[@name='username']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='username-error']" should contain text "Please enter at least 2 characters."
    When I clear element with xpath "//input[@name='username']"
    Then element with xpath "//label[@id='username-error']" should contain text "This field is required."
    When I type "AA" into element with xpath "//input[@name='username']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='username-error']" should not be displayed

#Fill out and validate “Username” field. Validate minimal “Username” field length requirement as 2 characters
  @cucumber3
  Scenario: Verify Username field different order
    Given I open url "https://skryabin.com/market/quote.html"
    Then I should see page title as "Get a Quote"
    When I type "AA" into element with xpath "//input[@name='username']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='username-error']" should not be present
    When I clear element with xpath "//input[@name='username']"
    When I type "A" into element with xpath "//input[@name='username']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='username-error']" should contain text "Please enter at least 2 characters."
    When I clear element with xpath "//input[@name='username']"
    Then element with xpath "//label[@id='username-error']" should contain text "This field is required."



