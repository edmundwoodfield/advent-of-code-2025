import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TachyonTest {

    List<String> problem = Arrays.asList(".......S.......",
            "...............",
            ".......^.......",
            "...............",
            "......^.^......",
            "...............",
            ".....^.^.^.....",
            "...............",
            "....^.^...^....",
            "...............",
            "...^.^...^.^...",
            "...............",
            "..^...^.....^..",
            "...............",
            ".^.^.^.^.^...^.",
            "...............");

    @Test
    void countSplitsTest() {

        var tachyon = new Tachyon();
        Assertions.assertEquals(21, tachyon.countSplits(problem));
    }

    @Test
    void quantumSplitsTest(){
        var tachyon = new Tachyon();
        Assertions.assertEquals(40L, tachyon.countQuantumSplits(problem));
    }
}
