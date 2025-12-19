import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private final List<Range> unspoiledIngredients;
    public InventoryManager(List<String> ranges){
        this.unspoiledIngredients = new ArrayList<>();
        for (var range : ranges){
            var lower = Long.parseLong(range.substring(0, range.indexOf('-')));
            var upper = Long.parseLong(range.substring(range.indexOf('-') + 1));
            this.unspoiledIngredients.add(new Range(lower,upper));
        }
    }
    public long countUnspoiledIngredients(List<String> ingredients) {
        var count = 0L;
        for (var ingredient: ingredients){
            var ingredientLong = Long.parseLong(ingredient);
            for (var range : this.unspoiledIngredients){
                if (ingredientLong >= range.lower && ingredientLong <= range.upper) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    private static class Range{
        private Range(long lower, long upper){
            this.lower = lower;
            this.upper = upper;
        }
        long lower;
        long upper;
    }

}
