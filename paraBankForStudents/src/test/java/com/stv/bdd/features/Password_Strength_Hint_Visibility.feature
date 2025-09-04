Feature: Password_Strength_Hint_Visibility

  Scenario Outline: Check the password note visibility
    Given registration page is loaded
    When the user enters "<password>" into the new password field
    Then the password note should be "<visibility>"
    Examples:
      | password        | visibility |
      | 1               | visible    |
      | 12345           | visible    |
      | 123456          | hidden     |
      | 123456790123456 | hidden     |
