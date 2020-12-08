import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CalculatorTest {

    //Тестирование сложения
    @ParameterizedTest
    @CsvSource({
            "10101,1010, 11111",
            "100,10, 110",
            "1000,11, 1011"
    })
    void AddTest(String a,String b,String res) {
        Calculator calculator = new Calculator();
        assertEquals(res, calculator.Add(a,b));
    }

    @ParameterizedTest
    @MethodSource("AddStringParameters")
    void AddTestWithMethodSource(String a,String b,String res) {
        Calculator calculator = new Calculator();
        assertEquals(res, calculator.Add(a,b));
    }

    static Stream<Arguments> AddStringParameters() {
        return Stream.of(
                arguments("10101","1010", "11111"),
                arguments("100","10", "110"),
                arguments("1000","11", "1011")
        );
    }

    //Тестирование вычитания
    @ParameterizedTest
    @CsvSource({
            "11111,1010, 10101",
            "110,10,100",
            "1011,11, 1000"
    })
    void SubTest(String a,String b,String res) {
        Calculator calculator = new Calculator();
        assertEquals(res, calculator.Sub(a,b));
    }

    @ParameterizedTest
    @MethodSource("SubStringParameters")
    void SubTestWithMethodSource(String a,String b,String res) {
        Calculator calculator = new Calculator();
        assertEquals(res, calculator.Sub(a,b));
    }

    static Stream<Arguments> SubStringParameters() {
        return Stream.of(
                arguments("10101","1010", "11111"),
                arguments("100","10", "110"),
                arguments("1000","11", "1011")
        );
    }


    //Тестирование деления
    @ParameterizedTest
    @CsvSource(
            {
            "100,10, 10",
            "11110,1010, 11"
    })
    void DivideTest(String a,String b,String res) {
        Calculator calculator = new Calculator();
        assertEquals(res, calculator.Divide(a,b));
    }

    @Test
    void exceptionTesting ()  {
        Calculator calculator = new Calculator();
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                calculator.Divide("1", "0"));
        assertEquals("Divider must not be 0", thrown.getMessage());
    }


    //Тестирование умножения
    @ParameterizedTest
    @CsvSource({
            "101,111,100011",
            "10,111,1110",
            "1001,111, 111111"
    })
    void MulTest(String a,String b,String res) {
        Calculator calculator = new Calculator();
        assertEquals(res, calculator.Multiple(a,b));
    }

    @ParameterizedTest
    @MethodSource("MulStringParameters")
    void MulTestWithMethodSource(String a,String b,String res) {
        Calculator calculator = new Calculator();
        assertEquals(res, calculator.Multiple(a,b));
    }

    static Stream<Arguments> MulStringParameters() {
        return Stream.of(
                arguments("101","111","100011"),
                arguments("10","111","1110"),
                arguments("1001","111","111111")
        );
    }


    //Тестирование Xor
    @ParameterizedTest
    @CsvSource({
            "1001,111,1110",
            "10,111,101",
            "1010,1110, 100"
    })
    void XorTest(String a,String b,String res) {
        Calculator calculator = new Calculator();
        assertEquals(res, calculator.Xor(a,b));
    }

    @ParameterizedTest
    @MethodSource("XorStringParameters")
    void XorTestWithMethodSource(String a,String b,String res) {
        Calculator calculator = new Calculator();
        assertEquals(res, calculator.Xor(a,b));
    }

    static Stream<Arguments> XorStringParameters() {
        return Stream.of(
                arguments("1001","111","1110"),
                arguments("10","111","101"),
                arguments("1010","1110","100")
        );
    }

}