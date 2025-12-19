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
    @Test
    void removePaperTest(){
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
        var finished = false;
        while (!finished){
            finished = true;
           for (var i = 0; i < shelves.size(); i++){
                var shelf = shelves.get(i);
                for (var j = 0; j < shelves.get(0).length(); j++){
                    if (shelf.charAt(j) == '@'){
                        if(forklift.isAccessible(i, j)){
                            count ++;
                            finished = false;
                            shelves.set(i,shelf.substring(0,j) + "." + shelf.substring(j + 1));
                            shelf = shelves.get(i);
                        }
                    }
                }
            }
            for(var line : shelves){
                System.out.println(line);}
           forklift.loadShelves(shelves);
            System.out.println("Current count: " + count);
        }

        Assertions.assertEquals(43, count);

    }
}
