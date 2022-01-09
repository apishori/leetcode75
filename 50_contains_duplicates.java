import java.util.*;
/*
Create set containing seen values and if ever found then return true.
*/
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int n : nums) {
            if(s.contains(n)) return true;
            s.add(n);
        }
        return false;
    }
}