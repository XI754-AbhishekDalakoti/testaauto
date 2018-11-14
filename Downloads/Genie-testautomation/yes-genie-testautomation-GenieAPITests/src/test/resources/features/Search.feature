Feature: Search or Landing Page
  As a user I should able to login into my app

  Background: User has logged in to Genie
    Given I navigate to "http://192.168.3.241:32512"

  @Regression
  Scenario: Search with MDM ID
    And I enter "admin" into input field having id "username"
    And I enter "test" into input field having id "password"
    When I click on element having class "buttonRipple"
    Then I enter "837630" into input field having class "_1GAtZAgoj0RN5y2WYQ-IKL"
    Then I wait for 2 sec
    When I click on element having xpath "//span[@class='_2v8jDvYep4VKSCVzkEmiR2 _1_5k62AIvTivhOaavf2P7e forWeb']"
    Then I wait for 2 sec
    Then I get Search result in tabular format with all details

  @Smoke
  Scenario: Search static parameter
    Then I wait for 2 sec
    And Search bar contains static search parameters

  @Regression
  Scenario: Search with wrong MDM ID
    Then I enter "83760" into input field having class "_1GAtZAgoj0RN5y2WYQ-IKL"
    Then I wait for 2 sec
    When I click on element having xpath "//span[@class='_2v8jDvYep4VKSCVzkEmiR2 _1_5k62AIvTivhOaavf2P7e forWeb']"
    Then I wait for 2 sec
    Then No search result should be displayed

  Scenario: Validate tool tip message on cust id by selecting checkbox
    Then I wait for 2 sec
    When I click on element having xpath "(//input[@type='checkbox'])[1]"
    Then I should get the tool tip with message

  Scenario: Search with custID
    Then I wait for 2 sec
    When I click on element having xpath "(//input[@type='checkbox'])[1]"
    Then I enter "837630" into input field having class "_1GAtZAgoj0RN5y2WYQ-IKL"
    Then I wait for 2 sec
    When I click on element having xpath "//span[@class='_2v8jDvYep4VKSCVzkEmiR2 _1_5k62AIvTivhOaavf2P7e forWeb']"
    Then I wait for 2 sec
    Then I get Search result in tabular format with all details

  @Regression
  Scenario: Close browser
    Then I close browser

