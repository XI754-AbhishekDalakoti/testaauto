@MI
Feature: Validate Search API

  Scenario: User search with query, isCustomerId and threshold
    When I set the base URL "MI"
    Then I validate the status is OK
  Then search api response schema is validated successfully
  #  Then I validate the response body
