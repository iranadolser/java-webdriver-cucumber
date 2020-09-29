package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UspsCalculatePrice extends Page {

    @FindBy(id = "CountryID")
    private WebElement country;

    // dynamic element
    private WebElement getShapeByValue(String value) {
        return getByXpath("//input[@value='" + value +"']");
    }

    public void selectCountry(String name) {
        new Select(country).selectByVisibleText(name);
    }

    public void selectShape(String name) {
        getShapeByValue(name).click();
    }
}
