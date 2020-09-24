@javaHomework9
Feature: Java Homework9and11

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
    Then I verify monthly pay is "372.86"


  @java11.2
  Scenario Outline: Verify calculator results
    Given I go to "calculator" page
    When I navigate to "Auto Loan Calculator"
    And I clear all calculator fields
    And I calculate
    Then I verify "Please provide a positive auto price." calculator error
    Then I verify another "Please provide a positive interest value." calculator error
    And I enter "<price>" price, "<months>" months, "<interest>" interest,"<downpayment>" downpayment, "<tradeIn>" trade-in, "<state>" state, "<tax>" percent tax,"<fees>"fees
    And I calculate

    Examples:
      | price | months | interest | downpayment | tradeIn | state      | tax | fees |
      | 25000 | 60     | 4.5      | 5000        | 0       | California | 7   | 300  |
      | 25000 | 60     | 4.5      | 1000        | 0       | California | 7   | 300  |
      | 25000 | 60     | 4.5      | 5000        | 12000   | California | 7   | 300  |


  @java12.1
  Scenario: I work with classes
    Given I try to create my classes





