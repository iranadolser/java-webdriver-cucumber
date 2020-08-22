@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    And I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"

  @predefined2 @smoke
  Scenario: Predefined steps for Yahoo
    Given I open url "https://www.yahoo.com/"
    Then I should see page title as "Yahoo"
    Then element with xpath "//input[@id='header-search-input']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='header-search-input']"
    And I click on element with xpath "//button[@id='header-desktop-search-button']"
    Then I wait for element with xpath "//*[@id='web']" to be present
    Then element with xpath "//*[@id='web']" should contain text "Cucumber"

  @predefined3 @smoke
  Scenario: Predefined steps for Ecosia
    Given I open url "https://www.ecosia.org/"
    Then I should see page title contains "Ecosia"
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    And I click on element with xpath "//button[@aria-label='Submit']"
    Then element with xpath "//div[@class='mainline-results']" should contain text "Cucumber"

  @predefined4 @smoke
  Scenario: Predefined steps for Swisscows
    Given I open url "https://swisscows.com/"
    Then I should see page title contains "Swisscows"
    When I type "Behavior Driven Development" into element with xpath "//input[@name='query']"
    And I click on element with xpath "//button[@class='search-submit']"
    When I wait for element with xpath "//article" to be present
    Then element with xpath "//div[@class='page-results']" should contain text "Cucumber"

  @predefined5
  Scenario: Responsive UI
    Given I open url "https://skryabin.com/market/quote.html"
    And I resize window to 1280 and 1024
    Then element with xpath "//b[@id='location']" should be displayed
    And I resize window to 800 and 1024
    Then element with xpath "//b[@id='location']" should be displayed
    And I resize window to 400 and 1024
    Then element with xpath "//b[@id='location']" should not be displayed

  @predefined6
  Scenario: Min length
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "a" into element with xpath "//input[@name='username']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//*[@id='username-error']" should be displayed
    And I clear element with xpath "//input[@name='username']"
    When I type "ab" into element with xpath "//input[@name='username']"
    Then element with xpath "//*[@id='username-error']" should not be displayed