Feature: GET List User
  @Latihan
  Scenario Outline: Get list users with valid parameter page
    Given Get list users with valid parameter page <page>
    When Send request get list users
    Then Status code should be 200 OK
    And Response body page value should be <page>
    Examples:
      | page |
      | 1    |
      | 2    |


  @Tugas @Negative
  Scenario Outline: Get list users with invalid parameter
    Given Get list users with page "<page>"
    When Send request get list users
    Then Should return status code 404 Not Found
    Examples:
      | page |
      | 2324 |
      | $$#% |

  @Tugas @Negative
  Scenario: Get a list of users with the page parameter exceeded
    Given Page 3 is an invalid parameter for get a list of users
    When Send request get list users
    Then Should return status code 404 Not Found

  @Tugas @Negative
  Scenario: Get list users with empty parameter page
    Given Empty parameter page for get list users
    When Send request get list users
    Then Should return status code 404 Not Found

