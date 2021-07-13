Feature: IMDB search

  Scenario Outline: Search for movies
    Given I have navigated to IMDB
    When I have searched for <searchInput> in the IMDB search bar
    Then I will see movies with titles that include <searchInput>
    And I will see sections for titles, names, keywords, and companies

    Examples:
      | searchInput | movieTitleResult |
      | Batman      | Batman           |
      | Iron Man 3  | Iron Man 3       |

  Scenario Outline: Search for movie that does not exist
    Given I have navigated to IMDB
    When I have searched for <searchInput> in the IMDB search bar
    Then I will see that no results were found for <searchInput>

    Examples:
      | searchInput         |
      | asdlkfhwelkrjhlkewa |


  Scenario Outline: Search for one movie's details
    Given I have navigated to IMDB
    When I have searched for <searchInput> in the IMDB search bar
    And I click Batman (1989)
    Then I will see a synopsis of Batman (1989)

    Examples:
      | searchInput | movieTitleResult |
      | Batman      | Batman           |
      | Iron Man 3  | Iron Man 3       |
