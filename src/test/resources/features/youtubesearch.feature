Feature: YouTube filter

  Scenario Outline: Filter by Upload Date
    Given I have navigated to YouTube
    And I have searched for <searchInput>
    When I click the <timeDurationFilter> filter
    Then I will see only videos between <start> minutes and <end> minutes long

    Examples:
      | searchInput | timeDurationFilter | start | end      |
      | Mozart      | Under 4 minutes    | 0     | 4        |
      | Mozart      | 4 - 20 minutes     | 4     | 20       |
      | Mozart      | Over 20 minutes    | 20    | 10000000 |

