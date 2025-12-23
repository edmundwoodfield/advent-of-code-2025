import java.time.LocalDateTime;
import java.util.HashMap;
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

    public long countQuantumSplits(List<String> problem) {
        var routes = new HashMap<Integer, Long>();
        var indices = new HashSet<Integer>();
        routes.put(problem.get(0).indexOf('S'), 1L);
        indices.add(problem.get(0).indexOf('S'));
        for(var i = 1; i < problem.size(); i++){
            var currentLine = problem.get(i);
            var nextMap = new HashMap<Integer, Long>();
            var nextIndices = new HashSet<Integer>();
            for (var index : indices){
                if (currentLine.charAt(index) == '^'){
                    nextIndices.add(index -1);
                    nextIndices.add(index + 1);
                    if (nextMap.containsKey(index - 1)){
                        nextMap.replace(index - 1, nextMap.get(index - 1) + routes.get(index));
                    }
                    else{
                        nextMap.put(index - 1, routes.get(index));
                    }
                    if (nextMap.containsKey(index + 1)){
                        nextMap.replace(index + 1, nextMap.get(index + 1) + routes.get(index));
                    }
                    else{
                        nextMap.put(index + 1, routes.get(index));
                    }
                }
                else {
                    if (nextMap.containsKey(index)){
                        nextMap.replace(index, nextMap.get(index) + routes.get(index));
                    }
                    else{
                        nextMap.put(index, routes.get(index));
                    }
                    nextIndices.add(index);
                }

            }
            routes = nextMap;
            indices = nextIndices;
            var total = 0L;
            for (var route : routes.values()){
                total += route;
            }
            System.out.println("Row " + i + ": " + indices.size() + " indices, " + total + " routes. " + LocalDateTime.now());
    }
        var total = 0L;
        for (var route : routes.values()){
            total += route;
        }
        return total;
}
}
