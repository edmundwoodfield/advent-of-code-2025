import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TachyonTest {
    @Test
    void countSplitsTest() {
        var problem = Arrays.asList(".......S.......",
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

        var tachyon = new Tachyon();
        Assertions.assertEquals(21, tachyon.countSplits(problem));
    }
}
