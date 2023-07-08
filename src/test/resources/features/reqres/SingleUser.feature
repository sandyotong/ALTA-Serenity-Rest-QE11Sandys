Feature: GET Single User
  @Tugas @Positive
  Scenario Outline: Get single user with valid parameter id
    Given Get single user with id <id>
    When Send get single user
    Then Should return status code 200 OK
    And Response body id should be <id>
    And Validate json scheme single user with valid parameter id
    Examples:
      | id |
      | 1  |
      | 2  |

  @Tugas @Negative
  Scenario Outline: Get single user with exceed id
    Given Get single user with exceed id <id>
    When Send get single user
    Then Should return status code 404 Not Found
    Examples:
      | id  |
      | 23  |
      | 739 |

  @Tugas @Negative
  Scenario Outline: Get single user with invalid parameter
    Given Get single user with first name "<firstName>"
    When Send request get single user
    Then Should return status code 404 Not Found
    Examples:
      | firstName |
      | Nanang    |
