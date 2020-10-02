package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CareersLanding;
import pages.CareersRecruit;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class CareersStepDefs {
    @And("I login as {string}")
    public void iLoginAs(String role) {
        new CareersLanding()
                .clickLogin()
                .login(getData(role));

    }

    @Then("I verify {string} login")
    public void iVerifyLogin(String role) {
        String expectedName = getData(role).get("name");
        String actualName = new CareersLanding().getLoggedUserName();
        assertThat(actualName).isEqualTo(expectedName);
    }

    @When("I remove {string} position")
    public void iRemovePosition(String title) throws InterruptedException {
        new CareersLanding()
                .clickRecruit()
                .removePosition(title);

    }

    @And("I verify {string} position is removed")
    public void iVerifyPositionIsRemoved(String title) {
        new CareersRecruit().refresh();
        boolean isVisible = new CareersRecruit().isPositionVisible(title);
        boolean errorsPresent = new CareersRecruit().areErrorsPresent();
        assertThat(errorsPresent).isFalse();
        assertThat(isVisible).isFalse();

    }
}
