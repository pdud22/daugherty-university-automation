Feature: YouTube filter

  Scenario Outline: Filter by Upload Date
    Given I have navigated to YouTube
    And I have searched for <searchInput>
    When I click the <uploadFilterType> filter
    Then I will see only videos with an upload date of <uploadDateTime>

    Examples:
      | searchInput | uploadFilterType          | uploadDateTime |
      | Mozart      | Uploaded today            | 7/8/2021       |
      | Mozart      | Uploaded in the last hour | 10:00 a.m.     |
