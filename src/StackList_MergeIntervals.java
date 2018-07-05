import java.io.*;
import java.util.*;

/*
 * Given a collection of intervals, 
 * merge all overlapping intervals.
 */
public class StackList_MergeIntervals {
  public static void main(String[] args) {
    Interval a = new Interval(1, 4);
    Interval b = new Interval(6, 7);
    Interval c = new Interval(2, 5);
    
    List<Interval> intervals = new LinkedList<Interval>();
    intervals.add(a);
    intervals.add(b);
    intervals.add(c);
    
    for(Interval result: merge(intervals)) {
      System.out.println("[" + result.start + ", " + result.end + "]"); 
    }
  }
  
  //O(nlogn)
  private static class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval a, Interval b) {
      if(a.start < b.start)
    	  return -1;
      else if(a.start == b.start)
    	  return 0;
      return 1; 
    }
  }
  
  public static List<Interval> merge(List<Interval> intervals) {
    Collections.sort(intervals, new IntervalComparator());
    
    //or use stack
    LinkedList<Interval> merged = new LinkedList<Interval>();
    
    for(Interval interval: intervals) {
      if(merged.isEmpty() || merged.getLast().end < interval.start) {
        merged.add(interval); 
      }
      
      else {
        merged.getLast().end = Math.max(merged.getLast().end, interval.end); 
      }
    }
    
    return merged;
  }
}

class Interval {
  public int start;
  public int end;
  
  public Interval(int s, int e) {
    start = s;
    end = e;
  }
}