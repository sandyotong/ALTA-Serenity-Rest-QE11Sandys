Feature: PATCH Update User
  @Tugas_Positive_Case
  Scenario Outline: Patch update user with valid id and JSON
    Given Patch update user with valid id <id> json
    When Send patch update user
    Then Status code should be 200 OK
    And Response body name was "<name>" and job was "<job>"
    And Validate patch update user JSON Schema
    Examples:
      | id | name     | job           |
      | 2  | morpheus | zion resident |

  @Tugas_Negative_Case
  Scenario: Patch update user with blank name and job
    Given Patch update user with empty name and job with id 2
    When Send patch update user
    Then Status code should be 400 Bad Request