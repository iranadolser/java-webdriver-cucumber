package definitions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


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
        getDriver().findElement(By.xpath("//select[@id='origincountry']")).isSelected();
        getDriver().findElement(By.xpath("//input[@id='originname']")).sendKeys("Robin Good");
        getDriver().findElement(By.id("originaddress1")).sendKeys("105 Treehouse");
        getDriver().findElement(By.xpath("//input[@id='originpostal']")).sendKeys("92603");
        WebElement city = getDriver().findElement(By.xpath("//input[@id='origincity']"));
        WebElement state = getDriver().findElement(By.xpath("//select[@id='originstate']"));
        //getWait().until(ExpectedConditions.textToBePresentInElementValue(city,"IRVINE"));
        getDriver().findElement(By.xpath("//input[@id='originemail']")).sendKeys("somebody@gmail.com");
        getDriver().findElement(By.xpath("//input[@id='originphone']")).sendKeys("9493383595");
        getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']")).isEnabled();

    }

}

