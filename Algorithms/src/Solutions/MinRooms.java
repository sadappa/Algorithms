package Solutions;

import java.io.*;
import java.util.*;

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

class MinRooms {
  
  class IntervalComparator implements Comparator<Interval> {
    
    public int compare(Interval i1, Interval i2) {
      return i1.start - i2.start;
    }
  }
  
   int findMinimumRooms(List<Interval> intervals) {
    
    Collections.sort(intervals, new IntervalComparator());
    
    List<Interval> rooms = new ArrayList<Interval>();
    
    Interval prev = intervals.get(0);
    Interval room = prev;
    rooms.add(room);
    
    for(int i = 1; i< intervals.size(); i++) {
      
      Interval curr = intervals.get(i);
      boolean needRoom = true;
      
      for (int j =0 ; j < rooms.size(); j++) {
        if (curr.start >= rooms.get(j).end) {
          
          // update the meeting end time
          rooms.get(j).end = curr.end;
          needRoom = false;
          break;
        }
      }
      
      if (needRoom) {
        Interval newRoom = curr;
        rooms.add(newRoom);
      }
        
    }
    return rooms.size();
    
  }
  // (1, 100) (2, 3) (3, 4) (4, 5) (5, 6)
  // (1,3)(2,6)(8,10)(15,18)
  
  public static void main(String[] args) {
    
    List<Interval> intervals = new ArrayList<>();
    
    MinRooms s = new MinRooms();
    
    intervals.add(new Interval(1,3));
    intervals.add(new Interval(2,6));
    intervals.add(new Interval(8,10));
    intervals.add(new Interval(15,18));
    intervals.add(new Interval(14,19));
    
    
    

    System.out.println(s.findMinimumRooms(intervals));

  }
}
