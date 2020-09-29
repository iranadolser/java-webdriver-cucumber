@javaHomework4
  Feature: Java Homework4


    @javahw4.1
    Scenario: Hellow World
      Given I say hello world
      And I manipulate with "my var" and "my Var"
    @javahw4.2
    Scenario: Print To Uppercase
      Then I print "my var" and "my Var" uppercase

    @javahw4.3
    Scenario: Print Length
      And I print length of "my var" and "my Var"

    @javahw4.4
    Scenario: String Exact Comparison
      Then I compare my strings "my var" and "my Var"

    @javahw4.5
    Scenario: String Ignoring Cases Comparison
      And I exclude cases while comparing my strings "my var" and "my Var"

    @javahw4.6
    Scenario: String Partial Comparison
      Then I partially compare strings "my var" and "my Var"

    @javahw4.once.completed
    Scenario: Other Variables
      Given I say hello world again
      And I manipulate with "To be" and "or not To be?"
      Then I print "To be" and "or not To be?" uppercase
      And I print length of "To be" and "or not To be?"
      Then I compare my strings "To be" and "or not To be?"
      And I exclude cases while comparing my strings "To be" and "or not To be?"
      Then I partially compare strings "To be" and "or not To be?"
      Then I partially compare strings "or not To be" and "To be?"
      Then I partially compare strings "or not To be" and "To be"
      Given I say hello world again
      And I manipulate with "Интересно" and "работает ли?"
      Then I print "интересно" and "работает ли?" uppercase
      And I print length of "Интересно" and "работает ли?"
      Then I compare my strings "Интересно" and "работает ли?"
      And I exclude cases while comparing my strings "Работает" and "работает"
      Then I partially compare strings "Работает" and "Еще как работает"
      Then I partially compare strings "Работает" and "Работает?"
      Then I partially compare strings "Работает с 7 до 17" and "Работает"
      Then I partially compare strings "東京" and "京"
      And I partially compare strings "あ、い、う、え、お" and "え、お"
