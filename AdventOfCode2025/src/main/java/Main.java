import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> inputStrings = new ArrayList<>();
        try (var reader = new BufferedReader(
                new InputStreamReader(Main.class.getResourceAsStream("/input_1.txt")))){
            String line;
            while ((line = reader.readLine()) != null){
                inputStrings.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        var safe = new Safe();

        for (var move : inputStrings){
            var direction = move.charAt(0);
            var distance = Integer.parseInt(move.substring(1));
            safe.rotate(direction, distance);
        }

        System.out.println("Zero Counter: " + safe.zeroCounter);
    }
}
