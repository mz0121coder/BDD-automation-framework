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

  @A5
  Scenario Outline: Home Page links
    Given I am on the Ebay Home Page
    When I click on '<link>'
    Then I navigate to '<url>' and page title contains '<title>'

    Examples:
      | link    | url                                                                | title                         |
      | Motors  | https://www.ebay.com/b/Auto-Parts-and-Vehicles/6000/bn_1865334     | eBay Motors                   |
      | Fashion | https://www.ebay.com/b/Clothing-Shoes-Accessories/11450/bn_1852545 | Clothing, Shoes & Accessories |
      | Toys    | https://www.ebay.com/b/Toys-Hobbies/220/bn_1865497                 | Toys & Hobbies                |
