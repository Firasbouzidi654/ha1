package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    //TODO hier weitere Tests erstellen


    //Teil 1 :
    //Green's



    @Test
    @DisplayName("should change positive number to negative")
    void testToggleToNegative() {
        var c1 = new Calculator();

        c1.pressDigitKey(5);
        c1.pressNegativeKey();

        String expected = "-5";
        String actual = c1.readScreen();

        assertEquals(expected, actual);
    }
    //Extra
    @Test
    @DisplayName("should display result after adding two negativ multi-digit numbers")
    void test2() {
        var c1 = new Calculator();
        c1.pressDigitKey(5);
        c1.pressNegativeKey();
        c1.pressBinaryOperationKey("-");
        c1.pressDigitKey(5);
        c1.pressEqualsKey();

        String expected = "-10";
        String actual = c1.readScreen();

        assertEquals(expected, actual);
    }


    //Teil 2 :
    //Red's
    @Test
    @DisplayName("should calculate percentage of a multi-digit number correctly")
    void test3() {
        var c1 = new Calculator();
        c1.pressDigitKey(6);
        c1.pressDigitKey(0);
        c1.pressDigitKey(0);
        c1.pressBinaryOperationKey("%");
        c1.pressEqualsKey();

        String expected = "6";
        String actual = c1.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should calculate reciprocal using 1/x key")
    void test4() {
        var c1 = new Calculator();
        c1.pressDigitKey(1);
        c1.pressDigitKey(0);
        c1.pressDigitKey(0);
        c1.pressBinaryOperationKey("1/x");


        String expected = "0.01";
        String actual = c1.readScreen();

        assertEquals(expected, actual);
    }
}

