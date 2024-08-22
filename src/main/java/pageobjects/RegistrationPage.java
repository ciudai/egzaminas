package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

        @FindBy(css = "a[href='/registruoti']")
        private WebElement buttonRegister;

        @FindBy(css = "#username")
        private WebElement inputUsername;

        @FindBy(css = "#password")
        private WebElement inputPassword;

        @FindBy(css = "#passwordConfirm")
        private WebElement inputPasswordConfirm;

        @FindBy(css = "button[type='submit']")
        private WebElement buttonSubmit;

        @FindBy(css = "span[id='username.errors']")
        private WebElement registrationError;


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void  clickButtonRegister() {
        buttonRegister.click();
    }
    public void typeUsername(String username) {
        inputUsername.sendKeys(username);
    }
    public void typePassword(String password) {
        inputPassword.sendKeys(password);
    }
    public void typePasswordConfirm(String passwordConfirm) {
        inputPasswordConfirm.sendKeys(passwordConfirm);
    }
    public void  clickButtonSubmit() {
        buttonSubmit.click();
    }
    public String getError() {
        return registrationError.getText();
    }
}
