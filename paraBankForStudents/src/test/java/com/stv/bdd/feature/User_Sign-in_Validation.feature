Feature: User Sign-in Validation

  Background:
    Given the login page is open

  Scenario: Attempt to sign in with an empty password
    When the user enters a valid email address into the email field
    And the user leaves the password field empty
    And the user clicks the sign in button
    Then a password required error message should be shown

  Scenario Outline: Attempt to sign in with an invalid email and a valid password
    When the user types "<email>" into the email field
    And the user types "<password>" into the password field
    And the user clicks the sign in button
    Then an invalid email error message should be displayed

    Examples:
      | email              | password    |
      | userexample.com    | password123 |
      | user@com           | password123 |
      | @example.com       | password123 |
      | user@              | password123 |
      | user@@example.com  | password123 |
      | user@example..com  | password123 |

