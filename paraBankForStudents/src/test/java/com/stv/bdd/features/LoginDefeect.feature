Feature: Show Password Enhancement
  As user
  I want to be able to toggle password visibility
  So that I can check my input
  Scenario: Password visibility toggle is missing
    Given the user is on the login page
    Then the password field should have a show password toggle