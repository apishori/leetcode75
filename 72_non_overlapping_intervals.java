import java.util.*;
/*
Sort intervals based on start time. if curr start overlaps with prev end then we remove the interval
that has a later end (as it will always overlap with more intervals in the future).
*/
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int prevEndTime = Integer.MIN_VALUE, remove = 0;
        for(int[] interval : intervals) {
            if(interval[0] < prevEndTime) {
                ++remove;
                prevEndTime = Math.min(prevEndTime, interval[1]);
            } else prevEndTime = interval[1];
        }
        return remove;
    }
}