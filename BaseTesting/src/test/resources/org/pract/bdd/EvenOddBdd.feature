Feature: Even Odd BDD Example - Checks if number is even or odd
  Scenario: Check for Even number
    Given Create the even odd check instance
    When I will pass 2
    Then output should be "Even"

  Scenario: Check for Odd number
    Given Create the even odd check instance
    When I will pass 3
    Then output should be "Odd"

