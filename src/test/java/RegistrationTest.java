import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.BasePage;
import pageobjects.RegistrationPage;

public class RegistrationTest extends BaseTest {

    BasePage basePage;
    RegistrationPage registrationPage;

    @Test

    void userCanRegister() {
        basePage = new BasePage(driver);
        registrationPage = new RegistrationPage(driver);

        registrationPage.clickButtonRegister();
        registrationPage.typeUsername("GabijaK");
        registrationPage.typePassword("Slaptazodis123");
        registrationPage.typePasswordConfirm("Slaptazodis123");
        registrationPage.clickButtonSubmit();
    }

    @Test

    void userCantRegisterWithEmptyValues() {
        basePage = new BasePage(driver);
        registrationPage = new RegistrationPage(driver);

        registrationPage.clickButtonRegister();
        registrationPage.typeUsername("");
        registrationPage.typePassword("");
        registrationPage.typePasswordConfirm("");
        registrationPage.clickButtonSubmit();

        String expectedResult = "Šį laukelį būtina užpildyti";
        String actualResult = registrationPage.getError();

        Assertions.assertEquals(expectedResult, actualResult);

        System.out.println(actualResult);
    }
}
