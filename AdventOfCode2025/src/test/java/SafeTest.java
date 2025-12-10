import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SafeTest {
    @Test
    void rotateTest(){
        var safe = new Safe();
        Assertions.assertEquals(50, safe.currentPosition);
        safe.rotate('R', 25);
        Assertions.assertEquals(75, safe.currentPosition);
        safe.rotate('R', 30);
        Assertions.assertEquals(5, safe.currentPosition);
        safe.rotate('L', 1);
        Assertions.assertEquals(4, safe.currentPosition);
        safe.rotate('L', 5);
        Assertions.assertEquals(99, safe.currentPosition);
    }

    @Test
    void zeroTest(){
        var safe = new Safe();
        var testData = Arrays.asList("L68","L30","R48","L5","R60","L55","L1","L99","R14","L82");
        for (var move : testData){
            var direction = move.charAt(0);
            var distance = Integer.parseInt(move.substring(1));
            safe.rotate(direction, distance);
        }
        Assertions.assertEquals(3, safe.zeroCounter);
        }
}
