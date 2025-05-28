Feature: Password Strength Hint Visibility

  Scenario Outline: Display password instruction note depending on password length
    Given the registration form is open
    When the user types "<password>" into the password input field
    Then the password instruction should be "<visibility>"

    Examples:
      | password      | visibility |
      | ab            | visible    |
      | test1         | visible    |
      | secure1       | hidden     |
      | longpassword  | hidden     |
