Feature: DELETE User
  @Latihan
  Scenario Outline: Delete user with valid parameter
    Given Delete user with valid id <id>
    When Send request delete user
    Then Status code should be 204 No Content
    Examples:
      | id |
      | 1  |
      | 2  |

  @Tugas @Negative
  Scenario: Delete user with exceeded parameter id
    Given Page 100 is an invalid parameter for delete a list of users
    When Send request delete user
    Then Should return status code 404 Not Found

  @Tugas @Negative
  Scenario Outline: Delete user with invalid parameter
    Given Delete user with invalid id "<id>"
    When Send request delete user
    Then Status code should be 400 Bad Request
    Examples:
      | id      |
      | 7895679 |
      | &*^**(  |