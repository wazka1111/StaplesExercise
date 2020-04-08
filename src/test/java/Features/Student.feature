Feature: Testing of Student Management API

  @post
  Scenario: Create new student using POST method
    Given New student object is created
    When  User perform POST operation
    Then  User is able to see response with new student details

  @get
  Scenario: Verification status code
    Given New student is created in the system
    When  User perform GET operation
    Then Valid status code is visible in the response

  @get
  Scenario: Verification student id
    Given New student is created in the system with unique id
    When  User perform GET operation
    Then Valid student id is visible in the response

  @get
  Scenario: Verification student first_name
    Given New student is created in the system with first_name
    When  User perform GET operation
    Then Valid student first_name is visible in the response

  @get
  Scenario: Verification student middle_name
    Given New student is created in the system with middle_name
    When  User perform GET operation
    Then Valid student middle_name is visible in the response

  @get
  Scenario: Verification student last_name
    Given New student is created in the system with last_name
    When  User perform GET operation
    Then Valid student last_name is visible in the response

  @get
  Scenario: Verification student date_of_birth
    Given New student is created in the system with date_of_birth
    When  User perform GET operation
    Then Valid student date_of_birth is visible in the response
