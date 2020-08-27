@javaHomework9
Feature: Java Homework9


  @javahw9.1
 Scenario: Unit converters steps
    Given I go to "unitconverters" page
    Then I select tab "Temperature" to use
    And I do convert "54" "Fahrenheit" to "Celsius"
    Then I select tab "Weight" to use
    And I do convert "170" "Pound" to "Kilogram"
    Then I select tab "Length" to use
    And I do convert "50" "Mile" to "Kilometer"

  @java9.2
  Scenario: Verify calculator results
    Given I go to "calculator" page
    When I navigate to "Auto Loan Calculator"
    And I clear all calculator fields
    And I calculate
    Then I verify "Please provide a positive auto price." calculator error
    Then I verify another "Please provide a positive interest value." calculator error
    And I enter "25000" price, "60" months, "4.5" interest,"5000" downpayment, "0" trade-in, "California" state, "7" percent tax,"300"fees
    And I calculate
    Then I verify montly pay is "372.86"







