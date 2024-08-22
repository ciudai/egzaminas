import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.BasePage;
import pageobjects.CalculatorPage;
import pageobjects.LoginPage;

public class LoginTest extends BaseTest{

    BasePage basePage;
    LoginPage loginPage;
    CalculatorPage calculatorPage;

        @Test

        public void userCanLogin() {
            basePage = new BasePage(driver);
            loginPage = new LoginPage(driver);

            loginPage.typeLoginUsername("GabijaK");
            loginPage.typeLoginPassword("Slaptazodis123");
            loginPage.clickButtonLogin();

            String expectedResult = "Logout, GabijaK";
            String actualResult = loginPage.getCurrentUser();

            Assertions.assertEquals(expectedResult, actualResult);

            System.out.println(actualResult);

        }

    @Test

    void userCantLoginWithoutRegisteredAccount() {
        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);

        loginPage.typeLoginUsername("Neregistruotas");
        loginPage.typeLoginPassword("Vartotojas");
        loginPage.clickButtonLogin();

        String expectedResult = "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi";
        String actualResult = loginPage.getError();

        Assertions.assertEquals(expectedResult, actualResult);

        System.out.println(actualResult);
    }

    @Test

    void canCalculate() {

        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);

        loginPage.typeLoginUsername("GabijaK");
        loginPage.typeLoginPassword("Slaptazodis123");
        loginPage.clickButtonLogin();

        loginPage.typeFirstNumber("3");
        loginPage.typeSecondNumber("2");
        loginPage.selectFunction("atimtis");
        loginPage.clickCalculate();

        String expectedResult = "3 - 2 = 1";
        String actualResult = loginPage.getResult();

        Assertions.assertEquals(expectedResult, actualResult);

        System.out.println(actualResult);
    }

    @Test

    void cantCalculateWithInvalidInput() {

        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);

        loginPage.typeLoginUsername("GabijaK");
        loginPage.typeLoginPassword("Slaptazodis123");
        loginPage.clickButtonLogin();

        loginPage.typeFirstNumber("a");
        loginPage.typeSecondNumber("b");
        loginPage.selectFunction("atimtis");
        loginPage.clickCalculate();

        String expectedResult = "invalid input";
        String actualResult = loginPage.getResult();

        Assertions.assertEquals(expectedResult, actualResult);

        System.out.println(actualResult);
    }

    @Test

    void searchPreviousOperations() {
        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);

        loginPage.typeLoginUsername("GabijaK");
        loginPage.typeLoginPassword("Slaptazodis123");
        loginPage.clickButtonLogin();

        loginPage.clickOperations();
    }
}
