import java.util.*;
/*
add intervals that end bfr new one then add new one or merge with most recent one.
Continue to add intervals or merge with previous until all are added
*/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> merged = new LinkedList<>();
        int i = 0;
        while(i < intervals.length && intervals[i][0] < newInterval[0]) {
            merged.add(intervals[i++]);
        }
        
        if(merged.isEmpty() || merged.getLast()[1] < newInterval[0]) {
            merged.add(newInterval);
        } else {
            merged.getLast()[1] = Math.max(merged.getLast()[1], newInterval[1]);
        }
        
        while(i < intervals.length) {
            int[] curr = intervals[i++];
            int[] prev = merged.getLast();
            
            if(prev[1] < curr[0]) {
                merged.add(curr);
            } else {
                prev[1] = Math.max(prev[1], curr[1]);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
    }
}