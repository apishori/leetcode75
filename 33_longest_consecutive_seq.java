import java.util.*;
/*
put all nums into a set and build a sequence from the first num of the seq
update longest seq accordingly
*/
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int num : nums) s.add(num);
        
        int longestStreak = 0;
        for(int num : s) {
            if(s.contains(num - 1)) continue;
            
            int currStreak = 1;
            while(s.contains(++num)) ++currStreak;
            longestStreak = Math.max(longestStreak, currStreak);
        }
        return longestStreak;
    }
}