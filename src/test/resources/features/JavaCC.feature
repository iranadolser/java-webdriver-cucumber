@javaCC
Feature: Java HW CC


  @javahwCC1
  Scenario: Java coding challenges
    Given I solve coding challenges
    And I check if entered integer 144 is divisible by 3 or 4

  @javahwCC2
  Scenario: Java coding challenges day 8
    Given I print all number from zero up to n = 21
    Then I print negative numbers n = -21 up to zero
    And I have to print my integers in array 1111 2222 3333 7777 9999
    And I print only even integers from array 1111 2222 3333 7777 9999
    Then I check if my array is empty
    And I check if array contains integer 0
    Then I print 20 numbers according to Buzz Fizz rule

  @javahwCC3
  Scenario: Java coding challenges day 10
    Given I input two numbers which are devided by five: numbers are 9.9995 and 10.00005
    Then I add two numbers 0.75 and -9.99 and print addition
    Then I add two numbers -2147483648.0 and 0.0 and print addition
    Then I add two numbers -2147483648.0 and 2147483648.0 and print addition
    Then I add two numbers 0 and 0.000001 and print addition
    Then I add two numbers -1.0001 and 1.0 and print addition
    Then I add two numbers 0 and 0.0 and print addition
    Then I add two numbers 2147483649 and 2147483648.0 and print addition
    And I reverse every third character of a string "WebDriver"
    And I reverse words in a sentence "I am Automation Engineer"

  @javahwCC4
  Scenario Outline: Java coding challenges day 11.1
    Given I try to find two max numbers in an array <arg0> <arg1> <arg2> <arg3>

    Examples:
      | arg0 | arg1 | arg2 | arg3 |
      | 7    | 25   | 0    | 1    |
      | 1    | 75   | -999 | 0    |
      | -1   | -11  | -78  | -5   |
      | 0    | 99   | 78   | -999 |
      | -3   | 0    | 0    | 1    |

  @javahwCC4
  Scenario Outline: Java coding challenges day 11.2
    Then I write a function that finds if array "<memb1>" "<memb2>" "<memb3>" "<memb4>" "<memb5>" contains duplicates
    Examples:
      | memb1 | memb2 | memb3 | memb4 | memb5 |
      | 3333  | 2222  | 3333  | 7777  | 9999  |
      | five  | six   | seven | null  | zero  |
      | one   | two   | three | one   | two   |


  @javahwCC4
  Scenario Outline: Java coding challenges day 11.3
    Given I write a function that finds if word "<word>" is palindrome
    Examples:
      | word                |
      | radar               |
      | refer               |
      | SAIPPUAKIVIKAUPPIAS |
      | Wow                 |
      | Oooo                |
      | Q                   |
      | radarNOradar        |
      | radarradar          |

  @javahwCC4
  Scenario Outline: Java coding challenges day 11.4
    Given I write a function that counts number of each character in a string "<string>"
    #Then I write a function that counts number of each character in a string "<string>"
    Examples:
      | string                 |
      | abracadabra            |
      | abracadabraabracadabra |
      | abvgedeika             |
      | wow                    |
      | x                      |
      | ooooooooooooOOOoxyzZ   |

