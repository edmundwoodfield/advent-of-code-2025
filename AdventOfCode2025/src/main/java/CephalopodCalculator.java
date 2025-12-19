import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CephalopodCalculator {
    public long calculate(List<String> problem) {
        var operations = Arrays.asList(problem.get(problem.size() - 1).split(" "));
        var operands = new ArrayList<List<Integer>>();
        var total = 0L;
        operations = operations.stream().filter(a -> !a.trim().isEmpty()).toList();
        for (var i = 0; i < problem.size() - 1; i++) {
            var operandsRow = Arrays.stream(problem.get(i)
                    .split(" "))
                    .filter(a -> !a.trim().isEmpty())
                    .map(Integer::valueOf).toList();
            operands.add(operandsRow);
        }
        for (var i = 0; i < operations.size(); i++){
            long columnTotal = operands.get(0).get(i);
            if (operations.get(i).equals("+")){
                for (var j = 1; j < operands.size(); j++){
                    var nextNumber = operands.get(j).get(i);
                    columnTotal += nextNumber;
                }
            }
            else{
                for (var j = 1; j < operands.size(); j++){
                    var nextNumber = operands.get(j).get(i);
                    columnTotal *= nextNumber;
                }
            }
            total += columnTotal;
        }
        return  total;
    }
}
