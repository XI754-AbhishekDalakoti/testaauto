@MI @regression @integration @sanity
Feature: Get all search  details for given mdmId
  As a Product Owner I want to get search details  for mdmId

  Background: API Setup Configuration
  	Given I configure the Rest setup for "MI"
  
  Scenario: Product Owner calls web service for a search details by mdmId
    When I get the market insight for below mdmId
    |mdmId|custId|customerName|customerSearchEnabled|DOB|addressCity|addressArea|homeBranch|assetRM|liabilityRM|groupID|businessSegment|partnerSegment|customerOpenDate|
    |837634|837634|Suresh Durrani|True|09/05/2011|
    Then response status code is 200
    And "search" value is "search results"
    And market response schema is validated successfully
    
    When I get the insight for name "deepak"
    Then response status code is 404
    