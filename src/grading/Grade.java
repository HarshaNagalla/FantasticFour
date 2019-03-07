package grading;


public class Grade implements Comparable<Grade> {
    private String key;
    private Double value;
    
    public Grade(String k) throws IllegalArgumentException {
        if (k == null || k.equals("")) throw new IllegalArgumentException();
        key = k;
        value = 0.0;
    }
    
    public Grade (String k, Double v) throws IllegalArgumentException {
        if (k == null || k.equals("")) throw new IllegalArgumentException();
        key = k;
        value = v;
    }
    
    public Grade (String k, double v) throws IllegalArgumentException {
        if (k == null || k.equals("")) throw new IllegalArgumentException();
        key = k;
        value = v;
    }
    
    public String getKey() {
        return key;
    }
    
    public Double getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        if(value == null) return String.format("%s:   NA", key);
        else return String.format("%s: %5.1f", key, value);
    }
    
    @Override
    public int compareTo(Grade g) {
        if(this.value == null && g.value != null) return -1;
        else if(this.value == null && g.value == null) return 0;
        else if(this.value != null && g.value == null) return 1;
        else return this.value.compareTo(g.value);
    }
}
