Feature: POST Create User
  @Tugas @Positive-Case
  Scenario: Post create new user with valid json should success then return 201 response code
    Given Post create user with valid json
    When Send request post create user
    Then Status code should be 201 Created
    And Response body name was "Sandy Tri Saputra" and job was "Quality Engineer"
    And Validate post create user JSON Schema

  @Tugas @Negative-Case
  Scenario: Post create new user with blank name and blank password should failed then return 400 response code
    Given Post create user with blank name and blank password json
    When Send post create user
    Then Status code should be 400 Bad Request

  @Tugas @Negative-Case
  Scenario: Post create new user with extra category should failed then return 400 response code
    Given Post create user with category name, job, and age
    When Send post create user
    Then Status code should be 400 Bad Request