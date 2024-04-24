Feature: Ebay Home Page Scenarios

  @A1
  Scenario: Navigate to advanced search page
    Given I am on the Ebay Home Page
    When I click on the Advanced link
    Then I navigate to the Advanced Search page

  @A2
  Scenario: Search for iphone 12
    Given I am on the Ebay Home Page
    When I search for 'iphone 12'
    Then I validate at least 5000 search results are present

  @A3
  Scenario: Search for samsung galaxy
    Given I am on the Ebay Home Page
    When I search for 'samsung galaxy'
    Then I validate at least 2000 search results are present

  @A4
  Scenario: Search for toy cars
    Given I am on the Ebay Home Page
    When I search for 'toy cars'
    Then I validate at least 500 search results are present

