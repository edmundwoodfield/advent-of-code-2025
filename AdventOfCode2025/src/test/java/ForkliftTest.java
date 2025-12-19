import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class ForkliftTest {
    @Test
    void accessPaperTest(){
        var shelves = Arrays.asList("..@@.@@@@." ,
                "@@@.@.@.@@" ,
                "@@@@@.@.@@" ,
                "@.@@@@..@." ,
                "@@.@@@@.@@" ,
                ".@@@@@@@.@" ,
                ".@.@.@.@@@" ,
                "@.@@@.@@@@" ,
                ".@@@@@@@@." ,
                "@.@.@@@.@.");

        var forklift = new Forklift(shelves);
        var count = 0;
        for (var i = 0; i < shelves.size(); i++){
            for (var j = 0; j < shelves.get(0).length(); j++){
                if (shelves.get(i).charAt(j) == '@'){
                    if(forklift.isAccessible(i, j)){
                        count ++;
                    }
                }
            }
        }
        Assertions.assertEquals(13, count);

    }
}
