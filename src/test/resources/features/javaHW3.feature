@predefined
Feature: Homework3

  @predefined3.1
  Scenario: Responsive UI
    Given I open url "https://skryabin.com/market/quote.html"
    And I resize window to 1280 and 1024
    Then element with xpath "//b[@id='location']" should be displayed
    And element with xpath "//b[@id='currentDate']" should be displayed
    And element with xpath "//b[@id='currentTime']" should be displayed
    And I resize window to 800 and 1024
    Then element with xpath "//b[@id='location']" should be displayed
    Then element with xpath "//b[@id='currentDate']" should be displayed
    Then element with xpath "//b[@id='currentTime']" should be displayed
    #Then I maximize window
    Then I resize window to 400 and 1024
    Then I wait for element with xpath "//b[@id='location']" to be present
    #Then element with xpath "//b[@id='location']" should not be displayed
    #Then element with xpath "//b[@id='currentDate']" should not be displayed
    #Then element with xpath "//b[@id='currentTime']" should not be displayed
    #Then element with xpath "//div[@class='well form-summary']//div[@class='row']" should be displayed

  @predefined3.2
  Scenario: Min username length
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "I" into element with xpath "//input[@name='username']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//*[@id='username-error']" should be displayed
    And I clear element with xpath "//input[@name='username']"
    When I type "IB" into element with xpath "//input[@name='username']"
    Then element with xpath "//*[@id='username-error']" should not be displayed

  @predefined3.3
  Scenario: email field behavior
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "wrong" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    And I clear element with xpath "//input[@name='email']"
    When I type "ThisOneIsBetter@mac.com" into element with xpath "//input[@name='email']"
    Then element with xpath "//label[@id='email-error']" should not be displayed



  @predefined3.4
  Scenario: password fields behavior
    Given I open url "https://skryabin.com/market/quote.html"
    When element with xpath "//input[@id='confirmPassword']" should be disabled
    And I type "SecretWord" into element with xpath "//input[@id='password']"
    Then element with xpath "//input[@id='confirmPassword']" should be enabled
    Then I type "SecretWor" into element with xpath "//input[@id='confirmPassword']"
    And   I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='confirmPassword-error']" should be displayed
    Then I clear element with xpath "//input[@id='confirmPassword']"
    And I type "Secretword" into element with xpath "//input[@id='confirmPassword']"
    Then element with xpath "//label[@id='confirmPassword-error']" should be displayed

  @predefined3.5
  Scenario: name field and modal dialog behavior
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@id='nameDialog']" should be displayed
    Then I type "Ivan" into element with xpath "//input[@id='firstName']"
    And I type "Ivanovich" into element with xpath "//*[@id='middleName']"
    Then I type "Ivanov" into element with xpath "//input[@id='lastName']"
    Then I click on element with xpath "//span[contains(text(),'Save')]"
    Then element with xpath "//input[@value='Ivan Ivanovich Ivanov']" should be displayed

  @predefined3.6
  Scenario: accepting privacy policy is required
    Given I open url "https://skryabin.com/market/quote.html"
    When element with xpath "//span[contains(text(),'I have read and accept')]/.." should be displayed
    Then I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should be displayed
    Then I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    Then I click on element with xpath "//button[@id='formSubmit']"
    When element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should not be displayed

  @predefined3.8
  Scenario: submit the form and verify the data
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "IB" into element with xpath "//input[@name='username']"
    And I type "SecretWord" into element with xpath "//input[@id='password']"
    Then I type "SecretWord" into element with xpath "//input[@id='confirmPassword']"
    When I click on element with xpath "//input[@id='name']"
    Then I type "Ivan" into element with xpath "//input[@id='firstName']"
    And I type "Ivanovich" into element with xpath "//*[@id='middleName']"
    Then I type "Ivanov" into element with xpath "//input[@id='lastName']"
    Then I click on element with xpath "//span[contains(text(),'Save')]"
    And I type "IVIVIV@mac.com" into element with xpath "//input[@name='email']"
    Then I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    And   I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//div[@class='well form-container container-fluid']" should be displayed
    And element with xpath "//div[@class='well form-container container-fluid']" should contain text "IB"
    And element with xpath "//div[@class='well form-container container-fluid']" should contain text "Ivan"
    And element with xpath "//div[@class='well form-container container-fluid']" should contain text "Ivanovich"
    And element with xpath "//div[@class='well form-container container-fluid']" should contain text "Ivanov"
    And element with xpath "//div[@class='well form-container container-fluid']" should contain text "IVIVIV@mac.com"
    But element with xpath "//div[@class='well form-container container-fluid']" should not contain text "SecretWord"

  @predefined3.7.1
  Scenario: optional
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "6172301234" into element with xpath "//input[@name='phone']"
    Then I click on element with xpath "//select[@name='countryOfOrigin']"
    And I click on element with xpath "//option[contains(text(),'Japan')]"
    Then I click on element with xpath "//Input[@name='gender'][@value='female']"
    Then I click on element with xpath "//input[@name='allowedToContact']"
    Then I type "This is my Address CA 92603" into element with xpath "//textarea[@id='address']"
    And I click on element with xpath "//option[contains(text(),'Toyota')]"
    Then I click on element with xpath "//button[@id='thirdPartyButton']"
    And I accept alert
    Then I type "11/07/1917" into element with xpath "//input[@id='dateOfBirth']"

  @predefined3.7.2
  Scenario: optional using anchor
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "6172301234" into element with xpath "//label[contains(text(),'Phone Number')]/..//input[@name='phone']"
    Then I click on element with xpath "//select[@name='countryOfOrigin']"
    And I click on element with xpath "//option[contains(text(),'Japan')]"
    Then I click on element with xpath "//Input[@name='gender'][@value='female']"
    Then I click on element with xpath "//input[@name='allowedToContact']"
    Then I type "This is my Address CA 92603" into element with xpath "//textarea[@id='address']"
    And I click on element with xpath "//option[contains(text(),'Toyota')]"
    Then I click on element with xpath "//button[@id='thirdPartyButton']"
    And I accept alert
    Then I type "11/07/1917" into element with xpath "//input[@id='dateOfBirth']"

    