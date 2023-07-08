Feature: Register User
  @Tugas @Positive
  Scenario Outline: User register with valid email and password
    Given User register with valid email and password
    When Send request post register user
    Then Status code should be 200 OK
    And Response body id should be <id> and token "<token>"
    And Validate json schema success register user
    Examples:
      | id | token |
      | 4  |QpwL5tke4Pnpja7X4       |


  @Tugas @Negative
  Scenario Outline: User register with valid email and blank password
    Given User register with valid email and blank password
    When Send request post register user
    Then Status code should be 400 Bad Request
    And Response body error should be "<error>"
    And Validate json schema failed register user with valid email and blank password
    Examples:
      |error|
      |Missing password     |

  @Tugas
  Scenario: Register with no email and valid password
    Given User register with blank email and valid password
    When Send request post register user
    Then Status code should be 400 Bad Request

  @Tugas
  Scenario: Register with not valid email format and valid password
    Given User register with not valid email format
    When Send request post register user
    Then Status code should be 400 Bad Request

  @Tugas
  Scenario: Register with empty request body
    Given User register with Empty request body for register
    When Send request post register user
    Then Status code should be 400 Bad Request