import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CephalopodCalculator {
    public long calculate(List<String> problem) {
        var operations = Arrays.asList(problem.get(problem.size() - 1).split(" (?=[+*])"));
        var operands = new ArrayList<List<String>>();
        var total = 0L;
        for (var i = 0; i < problem.size() - 1; i++) {
            var operandsRow = new ArrayList<String>();
            var startIndex = 0;
            var problemRow = problem.get(i);
            for (var operation : operations) {
                var numberWidth = operation.length();
                operandsRow.add(problemRow.substring(startIndex, startIndex + numberWidth));
                startIndex += numberWidth + 1;
            }
            operands.add(operandsRow);
        }
        for (var i = 0; i < operations.size(); i++){
            var operation = operations.get(i);
            var numbers = new ArrayList<Long>();
            for (var k = 0; k < operation.length(); k++){
                var builder = new StringBuilder();
                for (var j = 0; j < problem.size() -1; j++){
                    var character = operands.get(j).get(i).charAt(k);
                    if (character != ' '){
                        builder.append(character);
                    }
                }
                numbers.add(Long.parseLong(builder.toString()));
            }
            var subtotal = numbers.get(0);
            if (operation.startsWith("+")){
                for (int j = 1; j < numbers.size(); j++) {
                    subtotal += numbers.get(j);
                }
            }
            else{
                for (int j = 1; j < numbers.size(); j++) {
                    subtotal *= numbers.get(j);
                }
            }
            total += subtotal;

        }
        return total;
    }
}
