Feature: SimpleCalculator

  Scenario Outline: "<operation>" result of "<number1>" and "<number2>" should be "<expectedResult>"
    Given User is on Simple Calculator page
    When User types "<number1>" in Number1 input
    And User types "<number2>" in Number2 input
    And User selects "<operation>" operation from dropdown
    And User presses the CALCULATE button
    Then Result should display "<expectedResult>"
    Examples:
      | number1 | number2 | operation | expectedResult            |
      | 100     | 100     | DIVISION  | 1                         |
      | -100    | 100     | DIVISION  | -1                        |
      |         |         | DIVISION  | One number input is empty |
      | 100     |         | DIVISION  | One number input is empty |
      |         | 100     | DIVISION  | One number input is empty |
      | 5       | 0       | DIVISION  | Cannot divide by 0        |