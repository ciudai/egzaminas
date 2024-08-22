import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.CalculatorPage;


public class CalculatorTest {
    CalculatorPage calculatorPage;

    @Test
    void canCalc() {

        calculatorPage.typeFirstNumber("3");
        calculatorPage.typeSecondNumber("2");
        calculatorPage.selectFunction("atimtis");
        calculatorPage.clickCalculate();

        String expectedResult = "3 - 2 = 1";
        String actualResult =  calculatorPage.getResult();

        Assertions.assertEquals(expectedResult, actualResult);

        System.out.println(actualResult);
    }

}