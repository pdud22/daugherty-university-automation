Feature: Rotten Tomatoes search

  Scenario Outline: Filter by Upload Date
    Given I have navigated to Rotten Tomatoes
    When I have searched for <searchInput> in the Rotten Tomatoes search bar
    Then I will see movies with titles that include Batman

    Examples:
      | searchInput |
      | Batman      |
