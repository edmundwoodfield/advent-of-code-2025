import java.util.HashSet;
import java.util.List;

public class Tachyon {
    public int countSplits(List<String> problem) {
        var count = 0;
        var beamIndices = new HashSet<Integer>();
        beamIndices.add(problem.get(0).indexOf('S'));
        for(var i = 1; i < problem.size(); i++){
            var currentLine = problem.get(i);
            var nextSet = new HashSet<Integer>();
            for (var index : beamIndices){
                if (currentLine.charAt(index) == '^'){
                    count++;
                    if (index - 1 >= 0){
                        nextSet.add(index - 1);
                    }
                    if (index + 1 < currentLine.length()){
                        nextSet.add(index + 1);
                    }
                }
                else {nextSet.add(index);}
            }
            beamIndices = nextSet;
        }
        return count;
    }
}
