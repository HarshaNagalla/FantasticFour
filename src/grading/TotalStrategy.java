package grading;


import java.util.List;

public class TotalStrategy implements GradingStrategy {
    @Override
    public Grade calculate(String k, List<Grade> grades) throws SizeException {
        if(grades == null || grades.isEmpty()) throw new SizeException();
        double totalGrade = 0.0;
        for(Grade gg: grades) {
            totalGrade += Missing.doubleValue(gg.getValue());
        }
        return new Grade(k, totalGrade);
    }
}
