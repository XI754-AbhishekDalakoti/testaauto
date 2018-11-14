Feature: Login
  As a user I should able to login into my app

  Background: User is on Genie Page
    Given I navigate to "http://yesgenie.com:30978/"

  @Regression @Smoke
  Scenario Outline: Login button is disabled if both credentials are not entered
    When User enters "<Username>" and "<Password>"
    When I click on element having class "buttonRipple"
    Then The button should be disabled
    Examples:
      | Username | Password |
      |          |          |
      | admin    |          |
      |          | test     |

  Scenario: I login with invalid credential
    And I enter "admin" into input field having id "username"
    And I enter "secretpassword" into input field having id "password"
    When I click on element having class "buttonRipple"
    Then I should get error message

  @Regression
  Scenario: I login with valid credential
    And I enter "admin" into input field having id "username"
    And I enter "test" into input field having id "password"
    When I click on element having class "buttonRipple"
<<<<<<< HEAD
#    Then I should get logged-in
    Then I wait for 2 sec
    And Last Login date and time is displayed with basic info
    And I wait for 2 sec
    Then I should get logout
=======
    Then I should get logged-in with welcome message
    Then I wait for 2 sec
    And I validate last login format
    And Basic information
    And I wait for 2 sec
    Then I should get logout

>>>>>>>  Test added for Refined Search
