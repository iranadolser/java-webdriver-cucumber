package definitions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class MyUSPSStepDefs {
    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() throws InterruptedException {
        getDriver().get("https://www.usps.com/");
        WebElement mailAndShip = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(mailAndShip).perform();
        getDriver().findElement(By.xpath("//li[@class='tool-zip']//a[contains(@href,'Zip')]")).click();
        getDriver().findElement(By.xpath("//div[@id='zip-lookup-welcome']//a[contains(@href,'byaddress')][contains(@class,'primary')]")).click();
    }


    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) throws InterruptedException {

        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);

        Select stateSelect = new Select(getDriver().findElement(By.xpath("//select[@id='tState']")));
        stateSelect.selectByValue(state);
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();

    }
    @Then("I validate {string} zip code exists in  the result")
    public void iValidateZipCodeExistsInTheResult(String zip) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        WebElement result = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']"));
        wait.until(ExpectedConditions.textToBePresentInElement(result, zip));
    }

    @Given("I go to USPS page")
    public void iGoToUSPSPage() {
        getDriver().get("https://www.usps.com/");
    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        getDriver().get("https://postcalc.usps.com/");
    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String canada, String postcard) {
        WebElement country = getDriver().findElement(By.xpath("//select[@id='CountryID'][//body//option[72]]"));
        WebElement card = getDriver().findElement(By.xpath("//div[@class='form-group hidden-print']//div[@class='row']//div[1]//input[1]"));
        card.click();
   }

    @And("I define {int} quantity")
    public void iDefineQuantity(int quantity) {
        getDriver().findElement(By.xpath("//input[@placeholder='Quantity']")).sendKeys("2");


    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String coast) {
        getDriver().findElement(By.xpath("//input[@class='btn btn-pcalc btn-default']")).click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        WebElement result = getDriver().findElement(By.xpath("//tbody//div[contains(text(),'$2.40')]"));

    }
}







    ////WebElement listItemZip = getDriver().findElement(By.xpath("//li[@class='tool-zip']"));
    //getDriver().findElement(By.xpath("//*[@id='zip-lookup-welcome']"));
    //listItemZip.sendKeys(Keys.RETURN);
    //listItemZip.click();
    //Thread.sleep(2000);
    //getDriver().findElement(By.id("zip-lookup-welcome"));
    //getDriver().findElement(By.xpath("//*[contains(text(),'Find by City & State')]"));
    //getDriver().findElement(By.xpath("//div[@id='zip-lookup-welcome']"));


    //WebElement listItemZip = getDriver().findElement(By.xpath("//li[@class='tool-zip']//iframe"));
    //@And("I fill out {string} street, {string} city, {string} state\"")
    //public void iFillOutStreetCityState(String arg0, String arg1, String arg2) throws Throwable {    // Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}
    //}

