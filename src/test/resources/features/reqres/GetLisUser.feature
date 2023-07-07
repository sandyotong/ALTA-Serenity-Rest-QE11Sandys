Feature: GET List User
  @Tugas_Positive_Case
  Scenario Outline: Get list users with valid parameter page
    Given Get list users with valid parameter page <page>
    When Send request get list users
    Then Status code should be 200 OK
    And Response body page value should be <page>
    Examples:
      | page |
      | 1    |
      | 2    |


  @Tugas_Negative_Case
  Scenario Outline: Get list users with invalid parameter
    Given Get list users with page "<page>"
    When Send request get list users
    Then Should return status code 404 Not Found
    Examples:
      | page |
      | 2324 |
      | $$#% |