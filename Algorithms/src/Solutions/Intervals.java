package Solutions;

import java.util.ArrayList;
import java.util.List;

public class Intervals {

    int start = 0, end = 0, length = 0;
    List<Interval> list = new ArrayList<>();
    
    public void addInterval(int from, int to) {
    
        Interval newInt = new Interval(from, to);
        List<Interval> result = new ArrayList<>();
        
        for(Interval interval : list) {
        
            if (interval.end < newInt.start) {
            	result.add(interval);
            }
            else if(interval.start > newInt.end) {
            	result.add(newInt);
                newInt = interval;
            } 
            else if(interval.end >= newInt.start || interval.start<= newInt.end) {
                newInt = new Interval(Math.min(interval.start, newInt.start),Math.max(interval.end, newInt.end));
            }
        }
        
        result.add(newInt);
        list = result;
     
    }

    public int getTotalCoveredLength() {
        for(Interval interval :list) {
            length += (interval.end -interval.start);
        }
        return length;
    }
    
    public static void main(String[] args) {
    	Intervals i = new Intervals();
    	i.addInterval(3, 6);
    	i.addInterval(8, 9);
    	i.addInterval(1, 5);
    	System.out.println(i.getTotalCoveredLength());
    }
}