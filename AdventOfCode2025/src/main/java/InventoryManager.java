import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private List<Range> unspoiledIngredients;
    public InventoryManager(List<String> ranges) {
        this.unspoiledIngredients = new ArrayList<>();
        for (var range : ranges) {
            var lower = Long.parseLong(range.substring(0, range.indexOf('-')));
            var upper = Long.parseLong(range.substring(range.indexOf('-') + 1));
            this.unspoiledIngredients.add(new Range(lower, upper));
        }
        this.unspoiledIngredients.sort((o1, o2) -> {
            if (o1.lower < o2.lower || (o1.lower == o2.lower && o1.upper < o2.upper)) {
                return -1;
            } else if (o1.lower == o2.lower && o1.upper == o2.upper) {
                return 0;
            }
            else {
                return 1;
            }
        });
        this.unspoiledIngredients = getMergedRanges(this.unspoiledIngredients);
    }


    private List<Range> getMergedRanges(List<Range> unmerged){
            var needsToBeChecked = true;
        var mergedList = new ArrayList<Range>();

        while (needsToBeChecked){
            mergedList = new ArrayList<>();
            needsToBeChecked = false;
            for (var i = 0; i < unmerged.size(); i++) {
                var firstRange = unmerged.get(i);
                var nextRange = i == unmerged.size() - 1 ? null : unmerged.get(i + 1);
                if (nextRange != null && firstRange.upper >= nextRange.lower) {
                    needsToBeChecked = true;
                    var newRange = new Range(firstRange.lower, Math.max(firstRange.upper, nextRange.upper));
                    mergedList.add(newRange);
                    i++;
                } else {
                    mergedList.add(firstRange);
                }
            }
            unmerged = mergedList;
            }

        return mergedList;
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

    public long countTotalUnspoiledIngredients() {
        var total = 0L;
        for (var range : this.unspoiledIngredients){
            total += range.upper - range.lower + 1;
        }
        return total;
    }

    private static class Range{
        private Range(long lower, long upper){
            this.lower = lower;
            this.upper = upper;
        }
        private final long lower;
        private final long upper;
    }

}
