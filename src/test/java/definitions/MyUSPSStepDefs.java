package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static support.TestContext.getDriver;

public class MyUSPSStepDefs {
    @Given("I go to {string}")
    public void iGoTo(String page) {
        getDriver().get("https://www.usps.com/");
    }

    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() throws InterruptedException {
        getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();
        Thread.sleep(1000);

        WebElement listItemZip = getDriver().findElement(By.xpath("//li[@class='tool-zip']"));
        //getDriver().findElement(By.xpath("//*[@id='zip-lookup-welcome']"));
        //listItemZip.sendKeys(Keys.RETURN);
        //listItemZip.click();
        //Thread.sleep(2000);
        //getDriver().findElement(By.id("zip-lookup-welcome"));
        //getDriver().findElement(By.xpath("//*[contains(text(),'Find by City & State')]"));
        //getDriver().findElement(By.xpath("//div[@id='zip-lookup-welcome']"));
    }

    //WebElement listItemZip = getDriver().findElement(By.xpath("//li[@class='tool-zip']//iframe"));
    //@And("I fill out {string} street, {string} city, {string} state\"")
    //public void iFillOutStreetCityState(String arg0, String arg1, String arg2) throws Throwable {    // Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}
    //}
}
