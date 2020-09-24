package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import static support.TestContext.getDriver;

public class UnitConverterStepsDefs {
    @Given("I select tab {string} to use")
    public void iSelectTabToUse(String tabName) {
        getDriver().get("https://www.unitconverters.net/");

        switch (tabName) {
            case "Length":
                getDriver().findElement(By.xpath("//li[@id='menuon']//a[text()='Length']")).click();
                break;
            case "Temperature":
                getDriver().findElement(By.xpath("//div[@id='menu']//a[text()='Temperature']")).click();
                break;
            case "Weight":
                getDriver().findElement(By.xpath("//div[@id='menu']//a[text()='Weight']")).click();
                break;
            default:
                throw new RuntimeException("Unsupported page! " + tabName);
        }
    }
    @And("I do convert {string} {string} to {string}")
    public void iDoConvertTo(String numberToConvert, String requestFrom, String requestTo) {

        getDriver().findElement(By.xpath("//select[@id='calFrom']"));
        Select fromOne = new Select(getDriver().findElement(By.id("calFrom")));
        fromOne.selectByVisibleText(requestFrom);
        getDriver().findElement(By.xpath("//select[@id='calTo']"));
        Select toAnother = new Select(getDriver().findElement(By.id("calTo")));
        toAnother.selectByVisibleText(requestTo);
        getDriver().findElement(By.xpath("//input[@name='fromVal']")).sendKeys(numberToConvert);

        String converted = getDriver().findElement(By.xpath("//div[@id='calResults']")).getText();
        System.out.println("***********");
        System.out.println(converted + "\n");

  }
}
