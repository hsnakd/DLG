
Feature: DLG Title
  User Story :
  As a user, I should be able to assign tasks under Quick Navigate Menu.


  Background: Go to homepage
    Given navigate to homepage
    When user on the homepage


  @1
#  Headers with Scenario Outline
  Scenario Outline: Check headers at the top of the page
    And User should see there are 6 headings at the top of the page
    Then Verify "<title>" headers at the top of the page
    Examples:
      | title           |
      | Who We Are      |
      | Brands          |
      | Investors       |
      | Sustainability  |
      | Insights        |
      | News & Media    |


  @2 @smoke
#  Headers with Scenario
  Scenario: Check headings at the top of the page
    And User should see there are 6 headings at the top of the page
    Then Verify following headers at the top of the page with list

      | Who We Are      |
      | Brands          |
      | Investors       |
      | Sustainability  |
      | Insights        |
      | News & Media    |


  @3
#  Search Box-1
  Scenario:
    And user types "Values" in the search box
    And user click the search sign
    Then Check "Values" in the search results


#  @4
##  Search Box-2
#  Scenario:
#    And user types "Strategy" in the search box
#    Then Check "Strategy" in the search results

