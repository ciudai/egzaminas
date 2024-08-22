package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends BasePage {

    @FindBy(css = "input[placeholder='Prisijungimo vardas']")
    private WebElement loginUsername;

    @FindBy(css = "input[placeholder='Slaptažodis']")
    private WebElement loginPassword;

    @FindBy(css = "button[type='submit']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right']")
    private WebElement currentUser;

    @FindBy(xpath = "//span[contains(text(),'Įvestas prisijungimo vardas ir/ arba slaptažodis y')]")
    private WebElement loginError;


    @FindBy(css = "#sk1")
    private WebElement inputFirstNumber;

    @FindBy(css = "#sk2")
    private WebElement inputSecondNumber;

    @FindBy(css = "select[name='zenklas']")
    private WebElement selectFunction;

    @FindBy(css = "input[value='skaičiuoti']")
    private WebElement buttonCalculate;

    @FindBy(css = "#answer")
    private WebElement result;

    @FindBy(css = "a[href='/skaiciai']")
    private WebElement previousOperations;
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void typeLoginUsername(String userUsername) {
        loginUsername.sendKeys(userUsername);
    }

    public void typeLoginPassword(String userPassword) {
        loginPassword.sendKeys(userPassword);
    }

    public void clickButtonLogin() {
        buttonLogin.click();
    }
    public String getCurrentUser() {
        return currentUser.getText();
    }
    public String getError() {
        return loginError.getText();
    }

    public void typeFirstNumber(String firstNumber) {
        inputFirstNumber.sendKeys(firstNumber);
    }
    public void typeSecondNumber(String secondNumber) {
        inputSecondNumber.sendKeys(secondNumber);
    }
    public void selectFunction(String functionName) {
        Select functionDropdown = new Select(selectFunction);
        functionDropdown.selectByVisibleText(functionName);
    }
    public void clickCalculate() {
        buttonCalculate.click();
    }
    public String getResult() {
        return result.getText();
    }
    public void clickOperations() {
        previousOperations.click();
    }
}
