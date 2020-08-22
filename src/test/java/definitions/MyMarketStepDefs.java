package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;


public class MyMarketStepDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String page) {
        switch (page) {
            case "quote":
                getDriver().get("https://skryabin.com/market/quote.html");
                break;
            case "google":
                getDriver().get("https://www.google.com/");
                break;
            case "bing":
                getDriver().get("https://www.blomberg.com/");
                break;

            case "usps":
                getDriver().get("https://www.usps.com/");
                break;
            default:
                throw new RuntimeException("Unsupported page! " + page);
        }

    }

    @And("I print page details")
    public void iPrintPageDetails() {
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getWindowHandle());

    }

    @And("I go back and forward and refresh")
    public void iGoBackAndForwardAndRefresh() {
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }

    @When("I fill out page required fields")
    public void iFillOutPageRequiredFields() {

        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("GatesB");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("bgates@example.com");
        getDriver().findElement(By.xpath("//input[@id='name']")).click();
        getDriver().findElement(By.xpath("//input[@name='firstName']")).sendKeys("William");
        getDriver().findElement(By.xpath("//input[@name='middleName']")).sendKeys("Henry");
        getDriver().findElement(By.xpath("//input[@name='lastName']")).sendKeys("Gates");
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("SomeSecret");
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("SomeSecret");
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();

    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
    }

    @Then("I verify required fields")
    public void iVerifyRequiredFields() {
        String username = getDriver().findElement(By.xpath("//b[@name='username']")).getText();
        String email = getDriver().findElement(By.xpath("//b[@name='email']")).getText();
        String firstName = getDriver().findElement(By.xpath("//b[@name='firstName']")).getText();
        String middleName = getDriver().findElement(By.xpath("//b[@name='middleName']")).getText();
        String lastName = getDriver().findElement(By.xpath("//b[@name='lastName']")).getText();
        String password = getDriver().findElement(By.xpath("//b[@name='password']")).getText();

        Map<String, String> reqFields = new LinkedHashMap<>();
        reqFields.put("firstName", firstName);
        reqFields.put("middleName", middleName);
        reqFields.put("lastName", lastName);
        reqFields.put("username", username);
        reqFields.put("password", password);
        reqFields.put("email", email);
        System.out.println(reqFields);

        System.out.println();
        System.out.println(firstName);
        System.out.println(middleName);
        System.out.println(lastName);
        System.out.println(username);
        System.out.println(password);

    }

    @When("I enter wrong email format")
    public void iEnterWrongEmailFormat() {
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("bgates@example.comm");
        String email = String.valueOf(getDriver().findElement(By.xpath("//input[@name='email']")).getAttribute("value"));
        System.out.println();
        System.out.println(email);
        System.out.println(email.length());

    }

    @And("I delete just one character")
    public void iDeleteJustOneCharacter() {
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(Keys.BACK_SPACE);
        String email = String.valueOf(getDriver().findElement(By.xpath("//input[@name='email']")).getAttribute("value"));
        System.out.println();
        System.out.println(email);
        System.out.println(email.length());

    }


    @And("I fill out page optional fields")
    public void iFillOutPageOptionalFields() {

        getDriver().findElement(By.xpath("//option[contains(text(),'Japan')]")).click();
        getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys("6172303333");
        getDriver().findElement(By.xpath("//option[contains(text(),'Toyota')]")).click();
        getDriver().findElement(By.xpath("//Input[@name='gender'][@value='female']")).click();
        getDriver().findElement(By.xpath("//input[@name='allowedToContact']")).click();
        getDriver().findElement(By.xpath("//textarea[@id='address']")).sendKeys("California");
        getDriver().findElement(By.xpath("//input[@id='dateOfBirth']")).sendKeys("01/01/2001");

    }

    @Then("I verify all the fields")
    public void iVerifyAllTheFields() {

        String result = getDriver().findElement(By.xpath("//div[@id='quotePageResult']")).getText();
        System.out.println(result);

        assertThat(result).containsIgnoringCase("bgates@example.com");
        assertThat(result).containsIgnoringCase("GatesB");
        assertThat(result).contains("William");
        assertThat(result).contains("Henry");
        assertThat(result).contains("Gates");
        assertThat(result).containsIgnoringCase("Toyota");
        assertThat(result).containsIgnoringCase("Japan");
        assertThat(result).containsIgnoringCase("California");
        assertThat(result).containsIgnoringCase("6172303333");
        assertThat(result).containsIgnoringCase("01/01/2001");

        assertThat(result).doesNotContain("SomeSecret");

        String privacyPolicy = getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText();
        assertThat(privacyPolicy).isEqualTo("true");

    }

    @Then("I enter corrected email")
    public void iEnterCorrectedEmail() {
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("bgates@example.com");
    }
}
