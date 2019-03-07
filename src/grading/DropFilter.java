package grading;

import java.util.List;

public class DropFilter implements Filter {
    private boolean shouldDropLowest;
    private boolean shouldDropHighest;
    
    public DropFilter() {
        shouldDropLowest = true;
        shouldDropHighest = true;
    }
    
    public DropFilter(boolean SDLow, boolean SDHigh) {
        shouldDropLowest = SDLow;
        shouldDropHighest = SDHigh;
    }
    
    @Override
    public List<Grade> apply(List<Grade> grades) throws SizeException {
        if(grades == null) throw new SizeException();
        if(shouldDropLowest && shouldDropHighest && grades.size() < 3) throw new SizeException();
        if((shouldDropLowest || shouldDropHighest) && grades.size() < 2) throw new SizeException();
        if(!shouldDropLowest && !shouldDropHighest && grades.size() < 1) throw new SizeException();
        if(!shouldDropLowest && !shouldDropHighest) return grades;
        Grade lo, hi;
        lo = hi = grades.get(0);
        for(Grade g : grades) {
            if(g.compareTo(lo) < 0) lo = g;
            if(g.compareTo(hi) > 0) hi = g;
        }
        if(shouldDropLowest) grades.remove(lo);
        if(shouldDropHighest) grades.remove(hi);
        return grades;
    }
}
