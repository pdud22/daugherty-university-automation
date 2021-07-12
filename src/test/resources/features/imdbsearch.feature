Feature: IMDB search

  Scenario Outline: Search for movies
    Given I have navigated to IMDB
    When I have searched for <searchInput> in the IMDB search bar
    Then I will see movies with titles that include <searchInput>

    Examples:
      | searchInput | movieTitleResult |
      | Batman      | Batman           |
      | Iron Man 3  | Iron Man 3       |
