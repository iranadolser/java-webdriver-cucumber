/*package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HerokuAppPage extends Page{

    // constructor
    public HerokuAppPage() {
        url = "https://skryabin-careers.herokuapp.com/";
        title = "Careers Portal";

    }

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@placeholder='Please enter an Email']")
    private WebElement email;

    @FindBy(xpath = "//input[@placeholder='Please enter a Password']")
    private WebElement password;

    @FindBy(xpath = "//button[@id='loginButton']")
    private WebElement submitLoginButton;

    @FindBy(xpath = "//a[contains(text(),'Owen Kelley')]")
    private WebElement logedInVerification;


    public void clickLoginButton() {
        loginButton.click();
    }

    public String loginVerify() {
        return logedInVerification.getText();
    }





}*/
