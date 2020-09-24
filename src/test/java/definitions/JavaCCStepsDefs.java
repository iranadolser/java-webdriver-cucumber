package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.System.*;

public class JavaCCStepsDefs {
    @Given("I say hello world")
    public void iSayHelloWorld() {
        out.println(" ");
        out.println("Hello World from Home!");
    }

    @And("I manipulate with {string} and {string}")
    public void iManipulateWithAnd(String mystring1, String mystring2) {
        out.println("This is my string1: " + mystring1);
        out.println("This is my string2: " + mystring2);
    }

    @Then("I print {string} and {string} uppercase")
    public void iPrintAndUppercase(String mystring1, String mystring2) {
        out.println("This is my string1 in Uppercase: " + mystring1.toUpperCase());
        out.println("This is my string2 in Uppercase: " + mystring2.toUpperCase());
    }

    @Then("I print length of {string} and {string}")
    public void iPrintLengthOfAnd(String mystring1, String mystring2) {
        out.println("This is the length of my string1: " + mystring1.length());
        out.println("This is the length of my string2: " + mystring2.length());
    }

    @Then("I compare my strings {string} and {string}")
    public void iCompareMyStringsAnd(String mystring1, String mystring2) {
        out.println("My two strings are exactly the same: " + mystring1.equals(mystring2));
    }

    @And("I exclude cases while comparing my strings {string} and {string}")
    public void iExcludeCasesWhileComparingMyStringsAnd(String mystring1, String mystring2) {
        out.println("My strings are almost the same if ignore cases: " + mystring1.equalsIgnoreCase(mystring2));
    }

    @Then("I partially compare strings {string} and {string}")
    public void iPartiallyCompareStringsAnd(String mystring1, String mystring2) {
        out.println("One string contains another: " + mystring1.contains(mystring2));
    }

    @Given("I say hello world again")
    public void iSayHelloWorldAgain() {
        out.println(" ");
        out.println("Hello World from Home again!");
    }

    //Here starts homework 5

    @Given("I have two integers and two float to play with")
    public void iHaveTwoIntegersAndTwoFloatToPlayWith() {
        out.println(" ");
        out.println("This is int33 devided by int3: " + 33 / 3);
        out.println("This is int33 devided by fl3.0: " + 33 / 3.3);
        out.println("This is fl33.0 devided by fl3.3: " + 33.0 / 3.3);
        out.println("This is fl33.3 devided by fl3.3: " + 33.3 / 3.3);
    }

    @Given("I have two integers to manupulate")
    public void iHaveTwoIntegersToManupulate() {
        int num1 = 33;
        int num2 = 11;
        int sum = num1 + num2;
        int difference = num1 - num2;
        int quotient = num1 / num2;
        int product = num1 * num2;

        out.println(" ");
        out.println("My favorite two numbers are :" + num1 + " and " + num2);
        out.println("Here is their SUM: " + sum);
        out.println("Here is their difference:: " + difference);
        out.println("And here is their quotient: " + quotient);
        out.println("And also look at their product: " + product);

    }

    @Given("my favorite color is {string}")
    public void myFavoriteColorIs(String arg0favorite) {
        out.println(" ");
        out.println("My favorite color is: " + arg0favorite);
        String notFavoriteColor = "Brown";
        out.println("Is my favorite color here?: " + arg0favorite.equalsIgnoreCase(notFavoriteColor));

        if (arg0favorite.equalsIgnoreCase(notFavoriteColor)) {
            out.println("Yes " + arg0favorite + "is here and it's yours!");
        } else {
            out.println("No, it is not here, only " + notFavoriteColor + " is available. It's pity.");
        }
    }

    @Given("I have shopping array")
    public void iHaveShoppingArray() {
        String[] toBuy = {"butter", "bread ", "cheese", "wine", "coffee"};
        out.println();
        out.println(toBuy);
        out.println();
        for (String i : toBuy) {
            out.print(i + " ");
        }
        out.println();
        out.println("First out of products: " + toBuy[0]);
        out.println("Second out of products: " + toBuy[1]);
        out.println("3rd out of products: " + toBuy[2]);
        out.println("4th out of products: " + toBuy[3]);
        out.println("Last one out of products: " + toBuy[4]);
        out.println(" ");

    }

    @Given("I check numbers in my array")
    public void iCheckNumbersInMyArray() {
        int[] myNums = {1, -11, 111, -1111, 11111, 0};
        out.println();
        out.println(myNums);
        out.println();
        for (int i : myNums) {
            out.print(i + " ");
        }
        out.println();
        for (int i = 0; i < myNums.length; i++) {

            if (myNums[i] < 0) {
                out.println("myNums[i] " + myNums[i] + " is negative");
            } else if (myNums[i] == 0) {
                out.println("myNums[i] " + myNums[i] + " is equals null");
            } else {
                out.println("myNums[i] " + myNums[i] + " is positive");
            }
        }
    }

    @Given("I have array of days of a week")
    public void iHaveArrayOfDaysOfAWeek() {
        String[] myWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        out.println();
        for (String myDay : myWeek) {
            out.print(myDay + " ");
        }
        out.println();
        out.println("7th day of week is " + myWeek[6] + " and it is the best!");

    }

    //Here starts homework 6

    @Given("I have a map")
    public void iHaveAMap() {
        out.println();
        Map<String, String> info = new LinkedHashMap<>();
        info.put("firstName", "John");
        info.put("middleName", "George");
        out.println(info);
        for (String key : info.keySet()) {
            out.println(info.get(key));
        }

    }

    @And("I swap original order in other style")
    public void iSwapOriginalOrderAgainInOtherStyle() {

        out.println();
        out.println("---here swap happens ---");

        Map<String, String> info = new LinkedHashMap<>();
        info.put("firstName", "John");
        info.put("middleName", "George");
        Map<String, String> info1 = new LinkedHashMap<>();
        info1.put("firstName", info.get("middleName"));
        info1.put("middleName", info.get("firstName"));

        out.println(info);
        out.println(info1);

    }

    @Then("I try one more way to swap")
    public void iTryOneMoreWayToSwap() {

        out.println();
        out.println("------one more swap------");

        Map<String, String> info = new LinkedHashMap<>();
        info.put("firstName", "John");
        info.put("middleName", "George");
        String firstNameBeforeSwap = info.get("firstName");

        info.put("firstName", info.get("middleName"));
        info.put("middleName", firstNameBeforeSwap);

        out.println(info);
        for (String key : info.keySet()) {
            out.println(info.get(key));

        }
    }

    //Here starts homework 7

    @Given("I solve coding challenges")
    public void iSolveCodingChallenges() {
        out.println();
        out.println("<<<<<< CC >>>>>>>");

        int[] numsToSwap = {5, 2, 9, 7, 3};
        out.println("Before swap: ");
        for (int i : numsToSwap) {
            out.print(i + " ");
        }
        numsToSwap[2] = numsToSwap[2] + numsToSwap[4];
        numsToSwap[4] = numsToSwap[2] - numsToSwap[4];
        numsToSwap[2] = numsToSwap[2] - numsToSwap[4];

        out.println();
        out.println("After: ");
        for (int i : numsToSwap) {
            out.print(i + " ");
        }
    }

    @And("I check if entered integer {int} is divisible by {int} or {int}")
    public void iCheckIfEnteredIntegerIsDivisibleByOr(int numerator, int denom1, int denom2) {

        out.println();
        out.println("<<<< Let's divide by 3 or 4 >>>>>");
        if (numerator % 3 == 0 && numerator % 4 > 0) {
            out.println("numerator is divisible by " + denom1);
        } else if (numerator % 4 == 0 && numerator % 3 != 0) {
            out.println(numerator + " is divisible by " + denom2);
        } else if (numerator % (denom1 * denom2) == 0) {
            out.println(numerator + " is divisible by " + denom1 + " and " + denom2);
        } else {
            out.println(numerator + " is NOT divisible by " + denom1 + " or " + denom2);
        }
    }

    //Here starts homework 8

    @Then("I print all number from zero up to n = {int}")
    public void iPrintAllNumberFromZeroUpToN(int numN) {

        out.println("\n" + "HERE ARE MY NUMBERS FROM 0 TO n: ");
        for (int i = 0; i < numN; i++) {
            out.print(i + 1 + " ");
        }
        out.println();
    }

    @Then("I print negative numbers n = {int} up to zero")
    public void iPrintNegativeNumbersNUpToZero(int negNumN) {

        out.println("\n" + "HERE ARE MY NUMBERS FROM n TO zero:");
        for (int i = negNumN; i <= 0; i++) {
            out.print(i + " ");
        }
        out.println();
    }

    @And("I have to print my integers in array {int} {int} {int} {int} {int}")
    public void iHaveToPrintMyIntegersInArray(int arr0, int arr1, int arr2, int arr3, int arr4) {

        int[] myArrNums = {arr0, arr1, arr2, arr3, arr4};
        out.println("\n" + "Look at my Array Numbers here");
        for (int i : myArrNums) {
            out.print(i + " ");
        }
        out.println();
    }

    @And("I print only even integers from array {int} {int} {int} {int} {int}")
    public void iPrintOnlyEvenIntegersFromArray(int ar20, int ar21, int ar22, int ar23, int ar24) {
        int[] myAr2Nums = {ar20, ar21, ar22, ar23, ar24};
        out.println("\n" + "Look at my Even Array Numbers here");
        for (int i : myAr2Nums) {
            if (i % 2 == 0)
                out.print(i + " ");
        }
        out.println();

    }

    @Then("I check if my array is empty")
    public void iCheckIfArraysIsEmpty() {
        int[] myArrEmpOrNot = {};
        //int[] myArrEmpOrNot = {2, 7, 12};
        out.println("\n" + "Is my Array empty one?");

        if (myArrEmpOrNot.length == 0) {
            out.print("myArrEmpOrNot is really empty!" + "\n");
        } else {
            out.println("Nope, myArrEmpOrNot is not empty at all!" + "\n");
        }
    }

    @And("I check if array contains integer {int}")
    public void iCheckIfArrayContainsInteger(int anotherElement) {
        out.println("\nIs myArrToCheck contains " + anotherElement + "?");
        int[] myArrToCheck = {1, 10, 0, 110, 100};
        for (int i : myArrToCheck) {
            if (i == anotherElement) {
                out.println("Yes, this is true!");
            }
        }
    }

    @Then("I print {int} numbers according to Buzz Fizz rule")
    public void iPrintNumbersAccordingToBuzzFizzRule(int upToNum) {

        out.println("\n <<<< Let's divide by 3 and 5 with Fizz and Buzz >>>>>");
        for (int i = 1; i < upToNum + 1; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                out.print("Fizz ");
            } else if (i % 5 == 0 && i % 3 != 0) {
                out.print("Buzz ");
            } else if (i % 15 == 0) {
                out.print("FizBuzz ");
            } else {
                out.print(i + " ");
            }
        }
        out.println();
    }

    //Here starts homework 10

    @Given("I input two numbers which are devided by five: numbers are {double} and {double}")
    public void iInputTwoNumbersWhichAreDevidedByFiveNumbersAreAnd(double num1, double num2) {

        double[] myNums = {num1, num2};
        out.println("**********************");

        for (int i = 0; i < myNums.length; i++) {
            if (myNums[i] <= 1.0 || myNums[i] > 20.00) {
                out.println(myNums[i] + " is out of range.");
            } else if (myNums[i] < 10.00) {
                out.println(myNums[i] + " is in the range of 1 - 10 ");
            } else {
                out.println(myNums[i] + " is in the range of 10 - 20 ");
            }
        }


    }

    @Then("I add two numbers {double} and {double} and print addition")
    public void iAddTwoNumbersAndAndPrintAddition(double num1, double num2) {
        out.println("______________________");

        out.println("Sum of " + num1 + " and " + num2 + " is " + (num1 + num2));
    }


    /*c:"What challenge did you encounter in Selenium Automation?
     How did you solve it?"
     Every time I get challenged by Selenium Automation
     to locate element or apply method, I read the error messages
     and debug line by line. Sometimes solutions is found as
     simple as just changing an order of steps in scenario.*/


    @And("I reverse every third character of a string {string}")
    public void iReverseEveryThirdCharacterOfAString(String toRevThird) {
        out.println("______________________");

        out.println("Reversed every third character of " + toRevThird);
        for (int i = toRevThird.length() - 3; i >= 0; i = i - 3) {
            out.print(toRevThird.charAt(i));
        }
        out.println();
    }

    @And("I reverse words in a sentence {string}")
    public void iReverseWordsInASentence(String senToRev) {
        out.println("______________________");
        out.println(senToRev + "\n is reversed to: ");

        String[] words = senToRev.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            out.print(words[i] + " ");
        }
        out.println();
    }

    //Here starts homework 11

    @Given("I try to find two max numbers in an array {int} {int} {int} {int}")
    public void iTryToFindMaxNumbersInAnArray(int arg0, int arg1, int arg2, int arg3) {

        int[] myArrNums = {arg0, arg1, arg2, arg3};
        {
            out.println("\nHere are two max numbers in array: ");
            int max1 = arg0;
            int max2 = arg1;
            for (int i = 1; i < myArrNums.length; i++) {
                if (myArrNums[i] >= max1) {
                    max2 = max1;
                    max1 = myArrNums[i];
                } else if (myArrNums[i] < max1 && myArrNums[i] > max2) {
                    max2 = myArrNums[i];
                }
            }
            out.print(max1 + " and " + max2);
            out.println();
        }
    }

    @Then("I write a function that finds if array {string} {string} {string} {string} {string} contains duplicates")
    public void iWriteAFunctionThatFindsIfArrayContainsDuplicates(String memb1, String memb2, String memb3, String memb4, String memb5) {

        String[] toCheckForDuplicates = {memb1, memb2, memb3, memb4, memb5};
        for (int i = 0; i < toCheckForDuplicates.length; i++) {
            for (int j = 1; j < toCheckForDuplicates.length - 1; j++) {
                if (toCheckForDuplicates[i].equals(toCheckForDuplicates[j]) && i != j) {
                    out.print("\n" + toCheckForDuplicates[i] + " has duplicate");
                    out.println();
                }
            }
        }
    }

    @Given("I write a function that finds if word {string} is palindrome")
    public void iWriteAFunctionThatFindsIfWordIsPalindrome(String palindromeOrNot) {

        int i = 0;
        int j = palindromeOrNot.length();
        for (i = 0; i < (j / 2); i++) ;
        {
            if (palindromeOrNot.charAt(i) != palindromeOrNot.charAt(j - i - 1)) {
                System.out.print("\n" + palindromeOrNot + " is NOT a palindrome! \n");
            } else {
                System.out.print("\n" + palindromeOrNot + " is a palindrome! \n");
            }

        }
    }

    @Given("I write a function that counts number of each character in a string {string}")
    public void iWriteAFunctionThatCountsNumberOfEachCharacterInAString(String toCountC) {

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println();
        for (int a = 0; a < alphabet.length(); a++) {
            char letter = alphabet.charAt(a);
            toCountC = toCountC.toLowerCase();
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            for (int i = 0; i < toCountC.length(); ++i) {
                char c = toCountC.charAt(i);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
            if (map.get(letter) == null) {
            } else {
                System.out.println("Число повторов буквы " + letter + " - " + map.get(letter));
            }

        }

    }
}
