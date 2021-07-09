Feature: YouTube filter

  Scenario Outline: Filter by Upload Date
    Given I have navigated to YouTube
    And I have searched for <searchInput>
    When I click the <uploadDate> filter
    Then I will see only videos uploaded in the past <timeSpan>

    Examples:
      | searchInput | uploadDate | timeSpan |
      | Mozart      | Last hour  | Hour     |
      | Mozart      | Today      | Day      |
      | Mozart      | This week  | Week     |

