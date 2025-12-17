import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> inputStrings = new ArrayList<>();
        try (var reader = new BufferedReader(
                new InputStreamReader(Main.class.getResourceAsStream("/input_3.txt")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                inputStrings.add(line);
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
        var batteryBank = new BatteryBank();
        var total = 0L;
        for (var bank : inputStrings){
            var highest = batteryBank.highestJolt(bank);
            System.out.println(highest);
            total += highest;
        }
        System.out.println("total: " + total);
    }
}
