package grading;


public class Missing {
    private static final double DEFAULT_MISSING_VALUE = 0.0;
    
    public static double doubleValue(Double number) {
        if(number == null) return DEFAULT_MISSING_VALUE;
        else return number;
    }
    
    public static double doubleValue(Double number, double missingValue) {
        if(number == null) return missingValue;
        else return number;
    }
}
