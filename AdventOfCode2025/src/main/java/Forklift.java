import java.util.HashMap;
import java.util.List;

public class Forklift {

    public Forklift(List<String> shelves){
        this.RollMap = new HashMap<>();
        for (var i = 0; i < shelves.size(); i ++){
            for (var j = 0; j < shelves.get(i).length(); j ++){
                this.RollMap.put(i + ":" + j, shelves.get(i).charAt(j) == '@');
            }
        }
    }
    public void loadShelves(List<String> shelves){
        this.RollMap = new HashMap<>();
        for (var i = 0; i < shelves.size(); i ++){
            for (var j = 0; j < shelves.get(i).length(); j ++){
                this.RollMap.put(i + ":" + j, shelves.get(i).charAt(j) == '@');
            }
        }
    }
    private HashMap<String, Boolean>RollMap;
    public boolean isAccessible (int row, int column){
        var adjacentRolls = 0;
        for (var i = row - 1; i <= row + 1; i ++){
            for (var j = column - 1; j <= column + 1; j ++){
                if (i != row | j != column){
                    if (this.RollMap.containsKey(i + ":" + j)){
                        if (this.RollMap.get(i + ":" + j)){
                            adjacentRolls ++;
                            if (adjacentRolls > 3) return false;
                        }
                    }
                }
            }

        }
        return true;
    }
}
