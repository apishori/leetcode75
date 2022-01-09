import java.util.*;
/*
Sort by start time, and use pq to check what is the earliest room available (smallest end time).
At the end, the size of the pq will be the number of rooms needed
*/
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        for(int i = 1; i < intervals.length; ++i) {
            if(intervals[i][0] >= pq.peek()) pq.poll();
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}