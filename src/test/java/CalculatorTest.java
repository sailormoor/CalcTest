import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class CalculatorTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Beginning");
    }

    @Test
    public void testPlus() {
        Calculator calc = Calculator.instance.get();

        //arrange
        int x = 1, y = 2, expectedResult = 3;

        //act
        int result = calc.plus.apply(x, y);

        //assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expectedResult, result);

    }

    @Test
    public void testPow() {
        Calculator calc = Calculator.instance.get();

        //arrange
        int x = 9, expectedResult = 81;

        //act
        int result = calc.pow.apply(x);

        //assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testDevide() {
        Calculator calc = Calculator.instance.get();

        //arrange
        int x = 5, y = 0;

        //act
        //int result = calc.devide.apply(x, y);

        //assert
        Assertions.assertThrows(ArithmeticException.class,
                () -> calc.devide.apply(x, y));

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 255})
    public void testParams(int x) {
        Calculator  calc = Calculator.instance.get();

        //arrange
        int y = 0;

        //assert
        Assertions.assertThrows(ArithmeticException.class,
                () ->calc.devide.apply(x, y));
    }

    @ParameterizedTest
    @MethodSource("source")
    public void testParamsMultiply(int x, int y, int expectedResult) {
        Calculator calc = Calculator.instance.get();
        int result = calc.multiply.apply(x, y);
        Assertions.assertEquals(expectedResult, result);
    }

    public Stream<Arguments> source(){
        return Stream.of(
                Arguments.of(1, 6, 6),
                Arguments.of(0, 10, 0),
                Arguments.of(9, 6, 54)
        );
    }
}
