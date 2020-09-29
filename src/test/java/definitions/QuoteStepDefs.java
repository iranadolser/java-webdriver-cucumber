package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.QuoteForm;
import pages.QuoteResult;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class QuoteStepDefs {

    QuoteForm form = new QuoteForm();
    QuoteResult result = new QuoteResult();

    @When("I fill out required fields for {string} oop")
    public void iFillOutRequiredFieldsForOop(String role) {
        Map<String, String> user = getData(role);
        form.fillUsername(user.get("username"));
        form.fillEmail(user.get("email"));
        form.fillBothPasswords(user.get("password"));
        form.fillName(user.get("firstName"), user.get("lastName"));
        form.checkWithPrivacyPolicy();
    }

    @And("I submit the form oop")
    public void iSubmitTheFormOop() {
        form.submit();
    }

    @Then("I verify required fields for {string} oop")
    public void iVerifyRequiredFieldsForOop(String role) {
        Map<String, String> user = getData(role);
        String resultText = result.getResultText();
        assertThat(resultText).contains(user.get("username"));
        assertThat(resultText).contains(user.get("email"));
        assertThat(resultText).contains(user.get("firstName"));
        assertThat(resultText).contains(user.get("lastName"));

        assertThat(result.isAgreedToPrivacyPolicy()).isTrue();
        assertThat(result.getPasswordText()).isEqualTo("[entered]");

    }

    @When("I fill out optional fields for {string} oop")
    public void iFillOutOptionalFieldsForOop(String role) {
        Map<String, String> user = getData(role);
        form.fillContactInfo(user.get("contactPersonName"), user.get("contactPersonPhone"));
    }

    @Then("I verify optional fields for {string} oop")
    public void iVerifyOptionalFieldsForOop(String role) {
        Map<String, String> user = getData(role);

        assertThat(result.getResultText()).contains(user.get("contactPersonName"));
        assertThat(result.getResultText()).contains(user.get("contactPersonPhone"));
    }

    @Then("I see {string} error message {string}")
    public void iSeeErrorMessage(String errorField, String errorMessage) {
        String actualError = form.getErrorFieldText(errorField);
        assertThat(actualError).isEqualTo(errorMessage);

    }

    @Then("I don't see {string} error message")
    public void iDonTSeeErrorMessage(String errorField) {
        assertThat(form.isErrorFieldDisplayed(errorField)).isFalse();
    }
}