Feature: API Automation Testing ALTA QE Batch 11
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

  @Latihan
  Scenario: Post create new user with valid JSON
    Given Post create user with valid json
    When Send request post create user
    Then Status code should be 201 Created
    And Response body name was "Sandy Tri Saputra" and job was "Quality Engineer"
    And Validate post create user JSON Schema

  @Latihan
  Scenario Outline: Put update user with valid parameter id and JSON
    Given Put update user with valid id <id> and json
    When Send response put update user
    Then Status code should be 200 OK
    And Response body name was "Sandy Tri Saputra" and job was "QA Engineer"
    And Validate update list user JSON Schema
    Examples:
      | id |
      | 1  |
      | 2  |

  @Latihan
  Scenario Outline: Delete user with valid parameter id
    Given Delete user with valid id <id>
    When Send request delete user
    Then Status code should be 204 No Content
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |