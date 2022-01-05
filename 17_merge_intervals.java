import java.util.*;
/*
sort intervals by start time and then merge most recent interval with curr interval
if recent end >= curr start
*/
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> merged = new LinkedList<>();
        merged.add(intervals[0]);
        for(int[] interval : intervals) {
            int[] recent = merged.getLast();
            if(recent[1] < interval[0]) {
                merged.add(interval);
            } else {
                recent[1] = Math.max(recent[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
