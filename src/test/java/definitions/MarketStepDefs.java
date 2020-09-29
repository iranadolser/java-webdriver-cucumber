package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;
import static support.TestContext.getDriver;

public class MarketStepDefs {

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
                getDriver().get("https://www.bing.com/");
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
    }

    @And("I go back and forward, then refresh")
    public void iGoBackAndForwardThenRefresh() {
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();

    }

    @When("I fill out required fields for {string}")
    public void iFillOutRequiredFields(String role) {
        Map<String, String> user = getData(role);

        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys(user.get("username"));
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(user.get("email"));
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys(user.get("password"));
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys(user.get("password"));

        getDriver().findElement(By.xpath("//input[@id='name']")).click();
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys(user.get("firstName"));
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys(user.get("lastName"));
        getDriver().findElement(By.xpath("//span[text()='Save']")).click();
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        WebElement submitButton = getDriver().findElement(By.xpath("//button[@id='formSubmit']"));
        System.out.println(submitButton.getText());
        submitButton.click();
    }

    @Then("I verify required fields for {string}")
    public void iVerifyRequiredFields(String role) {
        Map<String, String> user = getData(role);
        String result = getDriver().findElement(By.xpath("//div[@id='quotePageResult']")).getText();
        System.out.println(result);

        assertThat(result).containsIgnoringCase(user.get("username"));
        assertThat(result).containsIgnoringCase(user.get("email"));
        assertThat(result).doesNotContain(user.get("password"));
        assertThat(result).contains(user.get("firstName") + " " + user.get("lastName"));

        String privacyPolicy = getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText();
        assertThat(privacyPolicy).isEqualTo("true");
    }

    @And("I print logs to the console")
    public void iPrintLogsToTheConsole() throws InterruptedException {
        Thread.sleep(1000);
        LogEntries logs = getDriver().manage().logs().get(LogType.BROWSER);
        System.out.println("Logs begin >>>>");

        for (LogEntry log : logs) {
            System.out.println(log);
        }

        System.out.println("Logs end >>>>");
    }

    @And("I {string} third party agreement")
    public void iThirdPartyAgreement(String action) {
        getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']")).click();
        if (action.equals("accept")) {
            getDriver().switchTo().alert().accept();
        } else if (action.equals("dismiss")) {
            getDriver().switchTo().alert().dismiss();
        } else {
            throw new RuntimeException("Incorrect action: " + action);
        }
    }

    @And("I fill out {string} name and {string} phone contact")
    public void iFillOutNameAndPhoneContact(String name, String phone) {

        // switch to iframe
        getDriver().switchTo().frame("additionalInfo");

        getDriver().findElement(By.xpath("//input[@id='contactPersonName']")).sendKeys(name);
        getDriver().findElement(By.xpath("//input[@id='contactPersonPhone']")).sendKeys(phone);

        // switch back to the parent page
        getDriver().switchTo().defaultContent();
    }

    @And("I verify document list contains {string}")
    public void iVerifyDocumentList(String expectedDoc) {

        String originalWindow = getDriver().getWindowHandle();

        getDriver().findElement(By.xpath("//button[contains(@onclick, 'new')]")).click();

        // switch to a new window
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }

        String allDocText = getDriver().findElement(By.xpath("//body")).getText();
        assertThat(allDocText).contains(expectedDoc);

        // switch back to original window
        getDriver().switchTo().window(originalWindow);
    }

}
