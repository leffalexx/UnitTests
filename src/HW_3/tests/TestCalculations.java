package HW_3.tests;
import HW_3.main.Calculations;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestCalculations {
    @ParameterizedTest
    @ValueSource(ints = {-8, 140, 16, 0, Integer.MIN_VALUE})
    void testEvenNumbers(int n) {
        assertTrue((Calculations.evenOddNumber(n)));
    }

    @ParameterizedTest
    @ValueSource(ints = {-999, 1, -5, Integer.MAX_VALUE})
    void testOddNumbers(int n) {
        assertFalse(Calculations.evenOddNumber(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {-985, 25, 100, 0, 106, 322})
    void testNumberNotInRange(int n) {
        assertFalse(Calculations.numberInInterval(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {26, 55, 72, 99})
    void testNumberWithinRange(int n) {
        assertTrue(Calculations.numberInInterval(n));
    }
}
