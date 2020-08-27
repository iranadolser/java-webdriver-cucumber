@javaHomework9
Feature: Unit Converter


  @javahw9converter
  Scenario: Unit converters steps
    Given I go to "unitconverters" page
    Then I select tab "Temperature" to use
    And I do convert "54" "Fahrenheit" to "Celsius"
    Then I select tab "Weight" to use
    And I do convert "170" "Pound" to "Kilogram"
    Then I select tab "Length" to use
    And I do convert "50" "Mile" to "Kilometer"

