Feature: Ebay Home Page Scenarios

  @A1
  Scenario: Advanced Search Link
    Given I am on the Ebay Home Page
    When I click on the Advanced link
    Then I navigate to the Advanced Search page

  @A2
  Scenario: Search items count
    Given I am on the Ebay Home Page
    When I search for iphone 12
    Then I validate at least 1000 search results are present