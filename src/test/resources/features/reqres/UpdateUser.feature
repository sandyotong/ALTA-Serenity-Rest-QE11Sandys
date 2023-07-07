Feature: PUT Update User
  @Tugas_Positive_Case
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

  @Tugas_Negative_Case
  Scenario: Put update user with invalid parameter json
    Given Put update user with valid id 1 and invalid json
    When Send response put update user
    Then Status code should be 400 Bad Request

  @Tugas_Negative_Case
  Scenario: Put update user with empty name and job
    Given Put update user with empty name and job with id 1
    When Send response put update user
    Then Status code should be 400 Bad Request

  @Tugas_Negative_Case
  Scenario: Put update user with no name, valid job, and valid id
    Given Put update user with empty name and valid job with id 2
    When Send response put update user
    Then Status code should be 400 Bad Request

  @Tugas_Negative_Case
  Scenario: Put Update user with valid name, no job, and valid id
    Given Put update user with valid name and empty job with id 2
    When Send response put update user
    Then Status code should be 400 Bad Request
