import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> inputStrings = new ArrayList<>();
        List<String> inputStrings2 = new ArrayList<>();
        try (var reader = new BufferedReader(
                new InputStreamReader(Main.class.getResourceAsStream("/input_5.txt")))) {
            String line;
            var target = inputStrings;
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()){
                    target = inputStrings2;
                    continue;
                }
                target.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//
//        var safe = new Safe();
//
//        for (var move : inputStrings){
//            var direction = move.charAt(0);
//            var distance = Integer.parseInt(move.substring(1));
//            safe.rotate(direction, distance);
//        }
//
//        System.out.println("Zero Counter: " + safe.zeroCounter);

//        String ranges = "";
//        try (var reader = new BufferedReader(
//                new InputStreamReader(Main.class.getResourceAsStream("/input_2.txt")))){
//            String line;
//            while ((line = reader.readLine()) != null){
//               ranges = line;
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        var giftShop = new GiftShop();
//        var rangeStrings = giftShop.rangeStrings(ranges);
//        long count = 0;
//        for (var range : rangeStrings){
//            count += giftShop.invalidIds(range);
//        }
//        System.out.println("Invalid id total: " + count);
//    }
//        var batteryBank = new BatteryBank();
//        var total = 0L;
//        for (var bank : inputStrings){
//            var highest = batteryBank.highestJolt(bank);
//            System.out.println(highest);
//            total += highest;
//        }
//        System.out.println("total: " + total);

//        var forklift = new Forklift(inputStrings);
//        var total = 0L;
//        for (var i = 0; i < inputStrings.size(); i++){
//            for (var j = 0; j < inputStrings.get(0).length(); j++){
//                if (inputStrings.get(i).charAt(j) == '@'){
//                    if(forklift.isAccessible(i, j)){
//                        total ++;
//                    }
//                }
//            }
//        }
//        System.out.println("total: " + total);
//
//        var count = 0;
//        var finished = false;
//        while (!finished){
//            finished = true;
//            for (var i = 0; i < inputStrings.size(); i++){
//                var shelf = inputStrings.get(i);
//                for (var j = 0; j < inputStrings.get(0).length(); j++){
//                    if (shelf.charAt(j) == '@'){
//                        if(forklift.isAccessible(i, j)){
//                            count ++;
//                            finished = false;
//                            inputStrings.set(i,shelf.substring(0,j) + "." + shelf.substring(j + 1));
//                            shelf = inputStrings.get(i);
//                        }
//                    }
//                }
//            }
//            forklift.loadShelves(inputStrings);
//        }
//        System.out.println("Total: " + count);
        var inventoryManager = new InventoryManager(inputStrings);
        System.out.println("number of unspoiled ingredients in stock: " + inventoryManager.countUnspoiledIngredients(inputStrings2));
        System.out.println("possible unspoiled ingredients: " + inventoryManager.countTotalUnspoiledIngredients());
    }

}
