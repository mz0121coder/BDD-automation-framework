Feature: Ebay Advanced Search Page

  @B1
  Scenario: Navigate to home page
    Given I am on Ebay Advanced Search Page
    When I click on Ebay Logo
    Then I navigate to Ebay Home Page

  @B2
  Scenario: Search for soap in Baby category
    Given I am on Ebay Advanced Search Page
    When I search for 'soap' in the 'Baby' category
    Then I confirm at least 10 search results are present

  @B3
  Scenario: Search for art in Music category
    Given I am on Ebay Advanced Search Page
    When I search for 'art' in the 'Music' category
    Then I confirm at least 20 search results are present

  @B4
  Scenario: Advanced search for iphone in price range
    Given I am on the Ebay Advanced Search Page
    When I advanced search for an item
      | keyword   | exclude     | min | max |
      | iphone 12 | refurbished | 300 | 900 |
    Then There are at least 5000 results

