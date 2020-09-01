package definitions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class MyUPStepDefs {

    @Given("I go to {string} home page")
    public void iGoToHomePage(String homeUPS) {
        getDriver().get("https://www.ups.com/us/en/Home.page");
    }
    @And("I open Shipping menu")
    public void iOpenShippingMenu() {
        getDriver().findElement(By.xpath("//a[@class='ups-analytics ups-menu_toggle'][text()='Shipping']")).click();
    }
    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
        getDriver().findElement(By.xpath("//a[text()='Create a Shipment:']")).click();

    }

    @When("I fill out origin shipment fields")
    public void iFillOutOriginShipmentFields() {
        getDriver().findElement(By.xpath("//input[@id='originname']"));


    }
}

