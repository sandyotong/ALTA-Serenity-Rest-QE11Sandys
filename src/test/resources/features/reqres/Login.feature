Feature: LOGIN User
  @Tugas @Positive
  Scenario Outline: User login with valid email and password
    Given User login with valid email and password
    When Send request post login user
    Then Status code should be 200 OK
    And Response body token should be "<token>"
    And Validate json schema success login user
    Examples:
      |token|
      |QpwL5tke4Pnpja7X4     |

  @Tugas @Negative
  Scenario Outline: User login with valid email and blank password
    Given User login with valid email and blank password
    When Send request post login user
    Then Status code should be 400 Bad Request
    And Response error body should be "<error>"
    And Validate json schema failed login user with valid email and blank password
    Examples:
      | error            |
      | Missing password |

  @Tugas @Negative
  Scenario: Login user with empty email and valid password
    Given User login with blank email and valid password
    When Send request post login user
    Then Status code should be 400 Bad Request



  @Tugas @Negative
  Scenario: User login with unregister email and password
    Given User login with unregister email and password
    When Send request post login user
    Then Status code should be 400 Bad Request
    And Validate json schema failed login user with unregister email and password

  @Tugas @Negative
  Scenario: Login with empty request body
    Given Empty request body
    When Send request post login user
    Then Status code should be 400 Bad Request