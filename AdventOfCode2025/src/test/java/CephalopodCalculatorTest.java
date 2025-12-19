import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CephalopodCalculatorTest {
    @Test
    void calculateTest() {
        var problem = Arrays.asList("123 328  51 64 ", " 45 64  387 23 ", "  6 98  215 314", "*   +   *   +  ");
        var calculator = new CephalopodCalculator();
        Assertions.assertEquals(3263827, calculator.calculate(problem));
    }
}
