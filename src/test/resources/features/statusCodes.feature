Feature: HTTP status codes
  Scenario Outline: Check the status HTTP status codes
    Given I have navigated to the status codes page
    When I click on a status code of <input>
    Then Application displays the message <outputCode>
    Examples:
      | input | outputCode |
      | 200   | 200        |
      | 301   | 301        |
      | 404   | 404        |