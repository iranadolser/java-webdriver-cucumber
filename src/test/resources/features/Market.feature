@market
  Feature: Marketing test suite

    @market0
    Scenario: Navigation to Quote page
      Given I go to "google" page
      And I print page details
      Then I go to "quote" page
      And I print page details
      And I go back and forward and refresh

    @market1
    Scenario: Required fields
      Given I go to "quote" page
      And I print page details
      When I fill out page required fields
      And I submit the form
      Then I verify required fields

    @market2
      Scenario: Add optional fields
      Given I go to "quote" page
      And I print page details
      When I fill out page required fields
      And I fill out page optional fields
      And I submit the form
      Then I verify all the fields

    @market3
    Scenario: Email field behavior
      Given I go to "quote" page
      When I enter wrong email format
      And I delete just one character
      Then I enter corrected email

