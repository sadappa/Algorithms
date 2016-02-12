package Solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
// meeting schedule

// Input is an array of meetings:
// array<pair<start_time, end_time>>
// We want to know minimum number of meeting rooms that can hold all these meetings

class MinRoomsEfficient {
  
  class EndpointComparator implements Comparator<Endpoint> {
    
    public int compare(Endpoint e1, Endpoint e2) {
      if (e1.value != e2.value) {
    	  return Integer.compare(e1.value, e2.value);
      } else if (e1.isStart && !e2.isStart) {
    	  return -1;  	  
      } else if (!e1.isStart && e2.isStart) {
    	  return 1;
      }
      return 0;
    }
  }
  
  int findMinimumRooms(List<Interval> intervals) {
	   
	List<Endpoint> points =  new ArrayList<>();
	
	for(Interval i : intervals) {
		points.add(new Endpoint(i.start, false));
		points.add(new Endpoint(i.end, true));
	}
    
    Collections.sort(points, new EndpointComparator());
    
    int minRooms = 0, rooms = 0;
    
    for(Endpoint e : points) {
    	if (!e.isStart) {
    		rooms++;
    		minRooms = Math.max(rooms, minRooms);
    	} else {
    		rooms--;
    	}
    }
    
    return minRooms;
  }
  // (1, 100) (2, 3) (3, 4) (4, 5) (5, 6)
  // (1,3)(2,6)(8,10)(15,18)
  
  public static void main(String[] args) {
    
    List<Interval> intervals = new ArrayList<>();
    
    MinRoomsEfficient s = new MinRoomsEfficient();
    
    intervals.add(new Interval(1,3));
    intervals.add(new Interval(2,6));
    intervals.add(new Interval(8,10));
    intervals.add(new Interval(15,18));
    intervals.add(new Interval(14,19));
    
    
    

    System.out.println(s.findMinimumRooms(intervals));

  }
}
