/*
package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class MyUSPStepDefs {
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
        WebElement results = getDriver().findElement(By.xpath("//table[@class='table']"));
        getDriver().manage().window().maximize();
        assertThat(results).isEqualToComparingOnlyGivenFields("$2.40");

    }

    @When("I perform {string} search")
    public void iPerformSearch(String freeBoxes) {
        getDriver().manage().window().maximize();
        getDriver().findElement(By.xpath("//a[text() = 'Search USPS.com']")).click();
        getDriver().findElement(By.xpath("//div[@class='repos']//a[contains(text(),'FREE BOXES')]")).click();

    }

    @And("I set {string} in filters")
    public void iSetInFilters(String mailAndShip) {
        getDriver().manage().window().maximize();
        getDriver().findElement(By.xpath("//span[contains(text(),'Filter by Category')]"));
        getDriver().findElement(By.xpath("//a[@class='dn-attr-a'][contains(text(),'Mail & Ship')]")).isSelected();

    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String searchResults) {
        String sResults = getDriver().findElement(By.xpath("//div[@id='dyn_nav']")).getText();
        assertThat(sResults).contains(searchResults);
    }

    @When("I select {string} in results")
    public void iSelectInResults(String priorityOrUsps) throws InterruptedException {
        getDriver().manage().window().maximize();
        //WebDriverWait wait = new WebDriverWait(getDriver(), 7);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'Priority Mail | USPS']")));
        Thread.sleep(1000);
        WebElement linkPriorityMail = getDriver().findElement(By.xpath("//span[text() = 'Priority Mail | USPS']"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(linkPriorityMail).perform();
        linkPriorityMail.click();

    }

    @And("I click on {string} button")
    public void iClickOnButton(String shipNow) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='button--primary']")));
        getDriver().findElement(By.xpath("//a[@class='button--primary']")).click();
    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() throws InterruptedException {
        String originalWindow = getDriver().getWindowHandle();
        //switch to sign in window
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }
        //WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        // Thread.sleep(5000);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='loginForm']")));
        getDriver().findElement(By.xpath("//*[@id='loginForm']"));
        getDriver().findElement(By.xpath("//input[@id='username']")).clear();
        getDriver().findElement(By.xpath("//input[@id='password']")).clear();
        getDriver().findElement(By.xpath("//button[@id='btn-submit']")).click();
        getDriver().findElement(By.xpath("//span[@class='error-txt-blk']"));
        //switch back to original window
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(originalWindow);
        }
    }

    @When("I go to {string} tab")
    public void iGoToTab(String help) {
        getDriver().findElement(By.xpath("//a[@class='menuitem'][text()='Help']")).click();

    }

    @And("I perform {string} help search")
    public void iPerformHelpSearch(String quadcopters) throws InterruptedException {
        getDriver().findElement(By.xpath("//a[@class='menuitem'][text()='Help']")).click();
        getDriver().findElement(By.xpath("//input[@placeholder='Search for a topic']")).sendKeys("Quadcopters");
        WebElement search = getDriver().findElement(By.xpath("//input[@placeholder='Search for a topic']"));
        search.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        String searchRes = getDriver().findElement(By.xpath("//div[@class='slds-text-heading--large noResultsTitle slds-p-bottom--large']")).getText();
        assertThat(searchRes).contains("No results");

    }

    @When("I navigate to Find a Location page")
    public void iNavigateToFindALocationPage() throws InterruptedException {
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//a[@class='nav-first-element menuitem']")).click();
        WebElement findLocation = getDriver().findElement(By.xpath("//p[text() = 'Find USPS Locations']"));
        findLocation.click();
    }

    @And("I filter by {string} locations types,{string}, {string} available services")
    public void iFilterByLocationsTypesAvailableServices(String arg0, String arg1, String arg2) {
        getDriver().manage().window().maximize();

        WebElement typeOffice = getDriver().findElement(By.xpath("//button[@id='post-offices-select']"));
        typeOffice.getAttribute("value");
        getDriver().findElement(By.xpath("//button[@id='service-type-select']")).click();
        WebElement serviceType = getDriver().findElement(By.xpath("//button[@id='service-type-select'][@value = 'pickup']"));
        serviceType.click();
        getDriver().findElement(By.xpath("//button[@id='available-service-select']"));

    }

    @When("I go to {string} under {string}")
    public void iGoToUnder(String arg0, String arg1) {

        getDriver().findElement(By.xpath("//a[@class='menuitem'][text()='Business']"));
        WebElement everyDoorDirect = getDriver().findElement(By.xpath("//a[text()='Every Door Direct Mail']"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(everyDoorDirect).perform();
    }


    }



*/
