@javaHomework9
Feature: Unit Converter

  Background: Unit converters steps
    Given I go to "unitconverters" page

  @javahw11converter
  Scenario Outline: Unit converters steps
    Then I select tab "Temperature" to use
    And I do convert "<value>" "Fahrenheit" to "Celsius"
    Examples:
      | value |
      | 54    |
      | 0     |
      | 103.9 |
      | 32    |


  @javahw11converter
  Scenario Outline: Unit converters steps
    Then I select tab "Weight" to use
    And I do convert "<value>" "Pound" to "Kilogram"
    Examples:
      | value |
      | 170   |
      | 0     |
      | 333.3 |
      | 0.1   |


  @javahw11converter
  Scenario Outline: Unit converters steps
    Then I select tab "Length" to use
    And I do convert "<value>" "Mile" to "Kilometer"
    Examples:
      | value      |
      | 1          |
      | 0.5        |
      | 1000       |
      | 2147483649 |

