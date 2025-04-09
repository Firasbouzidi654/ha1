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
    @DisplayName("should correctly change the sign of the  number ")
    void Green1_testNegativeNumber() {
        var  c1 = new Calculator();
        c1.pressDigitKey(5);
        c1.pressNegativeKey();

        String expected = "-5";
        String actual = c1.readScreen();
        assertEquals(expected, actual);

    }


    //Teil 2 :
    //RED's 
    @Test
    @DisplayName("should repeat last operation when pressing equals multiple times")
    void testRED_testRepeatedEqualsOperation() {
        var c1 = new Calculator();

        c1.pressDigitKey(1);
        c1.pressDigitKey(0);
        c1.pressBinaryOperationKey("-");
        c1.pressDigitKey(2);
        c1.pressEqualsKey(); // Calculation interne : 10 - 2 = 8
        c1.pressEqualsKey(); // interne : 8 - 2 = 6
        c1.pressEqualsKey(); // Final Result : 6 - 2 = 4


        String expected = "4";
        String actual = c1.readScreen();
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("should calculate percentage even after an operation")
    void testRED_testPercentageAfterBinaryOperation() {
        var C1 = new Calculator();

        C1.pressDigitKey(2);
        C1.pressDigitKey(0);
        C1.pressBinaryOperationKey("x");
        C1.pressDigitKey(1);
        C1.pressDigitKey(0); // Interne : 20 x 10 = 200
        C1.pressUnaryOperationKey("%"); // 20 * 0.1 = 2
        C1.pressEqualsKey(); // Ergebnis : 2

        String expected = "2";
        String actual = C1.readScreen();

        assertEquals(expected, actual);
    }








}

