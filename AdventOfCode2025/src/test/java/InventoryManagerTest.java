import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class InventoryManagerTest {
    @Test
    void countUnspoiledIngredientsTest() {
        var ranges = Arrays.asList("3-5","10-14","16-20","12-18");
        var ingredients = Arrays.asList("1","5","8","11","17","32");
        var inventoryManager = new InventoryManager(ranges);
        Assertions.assertEquals(3, inventoryManager.countUnspoiledIngredients(ingredients));
    }
    @Test
    void countTotalUnspoiledIngredientsTest() {
        var ranges = Arrays.asList("3-5","10-14","16-20","12-18");
        var inventoryManager = new InventoryManager(ranges);
        Assertions.assertEquals(14, inventoryManager.countTotalUnspoiledIngredients());
    }
}
