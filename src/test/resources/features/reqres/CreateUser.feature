Feature: POST Create User

  @Latihan
  Scenario: Post create new user with valid JSON
    Given Post create user with valid json
    When Send request post create user
    Then Status code should be 201 Created
    And Response body name was "Sandy Tri Saputra" and job was "Quality Engineer"
    And Validate post create user JSON Schema

  @Tugas @Negative
  Scenario: Post create new user with invalid JSON
    Given Post create user with invalid json
    When Send request post create user
    Then Status code should be 400 Bad Request

  @Tugas @Negative
  Scenario: Post create new user with another data
    Given Post create user with category name, job, and hobby
    When Send request post create user
    Then Status code should be 400 Bad Request

  @Tugas @Negative
  Scenario: Post create user with valid name and number data type of job
    Given Post create user with category name and job is 5678
    When Send request post create user
    Then Status code should be 400 Bad Request

  @Tugas @Negative
  Scenario: Post create user with valid name and number data type of job
    Given Post create user with name is $AND! and job is QA Engineer
    When Send request post create user
    Then Status code should be 400 Bad Request