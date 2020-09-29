package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HerokuAppPage;

public class HerokuAppStepDefs {
    @And("I login as {string}")
    public void iLoginAs(String role) {

        HerokuAppPage login = new HerokuAppPage();
        login.open();
        login.clickLoginButton();

        //Map<String, String> recruiter = getData(role);

    }

    @Then("I verify {string} login")
    public void iVerifyLogin(String recruiter) {


    }

    @When("I remove {string} position")
    public void iRemovePosition(String arg0) {

    }

    @And("I verify {string} position is removed")
    public void iVerifyPositionIsRemoved(String arg0) {

    }
}
