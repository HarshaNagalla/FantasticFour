package grading;
import java.util.*;
//import java.util.List;
//import java.util.Map;
//import java.util.HashMap;

public class WeightedTotalStrategy implements GradingStrategy {
    private Map<String, Double> weights;
    
    public WeightedTotalStrategy() {
        weights = new HashMap<>();
    }
    
    public WeightedTotalStrategy(Map<String, Double> w) {
        weights = w;
    }
    
    @Override
    public Grade calculate(String k, List<Grade> grades) throws SizeException {
        if(grades == null || grades.isEmpty()) throw new SizeException();
        if(weights == null) weights = new HashMap<>();
        double weightedTotalGrade = 0.0;
        for(Grade gg : grades) {
            Double w = weights.getOrDefault(gg.getKey(), 1.0);
            Double v = gg.getValue();
            w = Missing.doubleValue(w, 1.0);
            if(w < 0) w = 0.0;
            if(v == null) v = 0.0;
            weightedTotalGrade += (w * v);
        }
        return new Grade(k, weightedTotalGrade);
    }
}
