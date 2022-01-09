import java.util.*;
/*
Sort intervals by start time and then check if start time is less than prev end time.
*/
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int prevEnd = -1;
        for(int[] interval : intervals) {
            if(interval[0] < prevEnd) return false;
            prevEnd = interval[1];
        }
        return true;
    }
}