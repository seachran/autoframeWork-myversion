Feature: User_Sign_in_Validation

  Background:
    Given login page is loaded

  Scenario: Sign in with empty password field
    When the user enters correct email into the email field
    And the user enters empty password
    And the user clicks on the sign in button
    Then the empty password error message is displayed

  Scenario Outline: Sign in with invalid email and valid password
    When the user enters "<email>" into the email field
    And the user enters "<password>" into the password field
    Then the invalid email error message is displayed
    Examples:
      | email           | password    |
      | somegmailcom    | password111 |
      | somegmail.com   | password111 |
      | @gmail.com      | password111 |
      | some@           | password111 |
      | some@@gmail.com | password111 |
      | some@gmail..com | password111 |

