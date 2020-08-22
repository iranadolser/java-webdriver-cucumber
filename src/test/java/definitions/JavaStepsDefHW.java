package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.LinkedHashMap;
import java.util.Map;

public class JavaStepsDefHW {
    @Given("I say hello world")
    public void iSayHelloWorld() {
        System.out.println(" ");
        System.out.println("Hello World from Home!");
    }

    @And("I manipulate with {string} and {string}")
    public void iManipulateWithAnd(String mystring1, String mystring2) {
        System.out.println("This is my string1: " + mystring1);
        System.out.println("This is my string2: " + mystring2);
    }

    @Then("I print {string} and {string} uppercase")
    public void iPrintAndUppercase(String mystring1, String mystring2) {
        System.out.println("This is my string1 in Uppercase: " + mystring1.toUpperCase());
        System.out.println("This is my string2 in Uppercase: " + mystring2.toUpperCase());
    }

    @Then("I print length of {string} and {string}")
    public void iPrintLengthOfAnd(String mystring1, String mystring2) {
        System.out.println("This is the length of my string1: " + mystring1.length());
        System.out.println("This is the length of my string2: " + mystring2.length());
    }

    @Then("I compare my strings {string} and {string}")
    public void iCompareMyStringsAnd(String mystring1, String mystring2) {
        System.out.println("My two strings are exactly the same: " + mystring1.equals(mystring2));
    }

    @And("I exclude cases while comparing my strings {string} and {string}")
    public void iExcludeCasesWhileComparingMyStringsAnd(String mystring1, String mystring2) {
        System.out.println("My strings are almost the same if ignore cases: " + mystring1.equalsIgnoreCase(mystring2));
    }

    @Then("I partially compare strings {string} and {string}")
    public void iPartiallyCompareStringsAnd(String mystring1, String mystring2) {
        System.out.println("One string contains another: " + mystring1.contains(mystring2));
    }

    @Given("I say hello world again")
    public void iSayHelloWorldAgain() {
        System.out.println(" ");
        System.out.println("Hello World from Home again!");
    }

    //Here starts homework 5

    @Given("I have two integers and two float to play with")
    public void iHaveTwoIntegersAndTwoFloatToPlayWith() {
        System.out.println(" ");
        System.out.println("This is int33 devided by int3: " + 33 / 3);
        System.out.println("This is int33 devided by fl3.0: " + 33 / 3.3);
        System.out.println("This is fl33.0 devided by fl3.3: " + 33.0 / 3.3);
        System.out.println("This is fl33.3 devided by fl3.3: " + 33.3 / 3.3);
    }

    @Given("I have two integers to manupulate")
    public void iHaveTwoIntegersToManupulate() {
        int num1 = 33;
        int num2 = 11;
        int sum = num1 + num2;
        int difference = num1 - num2;
        int quotient = num1 / num2;
        int product = num1 * num2;

        System.out.println(" ");
        System.out.println("My favorite two numbers are :" + num1 + " and " + num2);
        System.out.println("Here is their SUM: " + sum);
        System.out.println("Here is their difference:: " + difference);
        System.out.println("And here is their quotient: " + quotient);
        System.out.println("And also look at their product: " + product);

    }

    @Given("my favorite color is {string}")
    public void myFavoriteColorIs(String arg0favorite) {
        System.out.println(" ");
        System.out.println("My favorite color is: " + arg0favorite);
        String notFavoriteColor = "Brown";
        System.out.println("Is my favorite color here?: " + arg0favorite.equalsIgnoreCase(notFavoriteColor));

        if (arg0favorite.equalsIgnoreCase(notFavoriteColor)) {
            System.out.println("Yes " + arg0favorite + "is here and it's yours!");
        } else {
            System.out.println("No, it is not here, only " + notFavoriteColor + " is available. It's pity.");
        }
    }

    @Given("I have shopping array")
    public void iHaveShoppingArray() {
        String[] toBuy = {"butter", "bread ", "cheese", "wine", "coffee"};
        System.out.println();
        System.out.println(toBuy);
        System.out.println();
        for (String i : toBuy) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("First out of products: " + toBuy[0]);
        System.out.println("Second out of products: " + toBuy[1]);
        System.out.println("3rd out of products: " + toBuy[2]);
        System.out.println("4th out of products: " + toBuy[3]);
        System.out.println("Last one out of products: " + toBuy[4]);
        System.out.println(" ");

    }

    @Given("I check numbers in my array")
    public void iCheckNumbersInMyArray() {
        int[] myNums = {1, -11, 111, -1111, 11111, 0};
        System.out.println();
        System.out.println(myNums);
        System.out.println();
        for (int i : myNums) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < myNums.length; i++) {

            if (myNums[i] < 0) {
                System.out.println("myNums[i] " + myNums[i] + " is negative");
            } else if (myNums[i] == 0) {
                System.out.println("myNums[i] " + myNums[i] + " is equals null");
            } else {
                System.out.println("myNums[i] " + myNums[i] + " is positive");
            }
        }
    }

    @Given("I have array of days of a week")
    public void iHaveArrayOfDaysOfAWeek() {
        String[] myWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        System.out.println();
        for (String myDay : myWeek) {
            System.out.print(myDay + " ");
        }
        System.out.println();
        System.out.println("7th day of week is " + myWeek[6] + " and it is the best!");

    }

    //Here starts homework 6

    @Given("I have a map")
    public void iHaveAMap() {
        System.out.println();
        Map<String, String> info = new LinkedHashMap<>();
        info.put("firstName", "John");
        info.put("middleName", "George");
        System.out.println(info);
        for (String key : info.keySet()) {
            System.out.println(info.get(key));
        }

    }

    @And("I swap original order in other style")
    public void iSwapOriginalOrderAgainInOtherStyle() {

        System.out.println();
        System.out.println("---here swap happens ---");

        Map<String, String> info = new LinkedHashMap<>();
        info.put("firstName", "John");
        info.put("middleName", "George");
        Map<String, String> info1 = new LinkedHashMap<>();
        info1.put("firstName", info.get("middleName"));
        info1.put("middleName", info.get("firstName"));

        System.out.println(info);
        System.out.println(info1);

    }

    @Then("I try one more way to swap")
    public void iTryOneMoreWayToSwap() {

        System.out.println();
        System.out.println("------one more swap------");

        Map<String, String> info = new LinkedHashMap<>();
        info.put("firstName", "John");
        info.put("middleName", "George");
        String firstNameBeforeSwap = info.get("firstName");

        info.put("firstName", info.get("middleName"));
        info.put("middleName", firstNameBeforeSwap);

        System.out.println(info);
        for (String key : info.keySet()) {
            System.out.println(info.get(key));

        }
    }

    //Here starts homework 7

    @Given("I solve coding challenges")
    public void iSolveCodingChallenges() {
        System.out.println();
        System.out.println("<<<<<< CC >>>>>>>");

        int[] numsToSwap = {5,2,9,7,3};
        System.out.println("Before swap: ");
        for (int i : numsToSwap) {
            System.out.print(i + " ");
        }
        numsToSwap[2]=numsToSwap[2]+numsToSwap[4];
        numsToSwap[4]=numsToSwap[2]-numsToSwap[4];
        numsToSwap[2]=numsToSwap[2]-numsToSwap[4];

        System.out.println();
        System.out.println("After: ");
        for (int i : numsToSwap) {
            System.out.print(i + " ");
        }
    }

    @And("I check if entered integer {int} is divisible by {int} or {int}")
    public void iCheckIfEnteredIntegerIsDivisibleByOr(int numerator, int denom1, int denom2){

        System.out.println();
        System.out.println("<<<< Let's divide by 3 or 4 >>>>>");
        if (numerator % 3 == 0 && numerator % 4 > 0){
            System.out.println("numerator is divisible by " + denom1);
        } else if (numerator % 4 == 0 && numerator % 3 != 0) {
            System.out.println(numerator + " is divisible by " + denom2);
        } else if (numerator % (denom1*denom2) == 0){
            System.out.println(numerator + " is divisible by " + denom1 + " and " + denom2);
        } else {
            System.out.println(numerator + " is NOT divisible by " + denom1 + " or " + denom2);
        }
    }
}