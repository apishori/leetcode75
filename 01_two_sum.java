import java.util.*;
/*
Create a map of the difference between target and nums[i] to its index.
If we find a number in the map then return the current index and map value
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> m = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++) {
            if(m.containsKey(nums[i])) {
                res[0] = i;
                res[1] = m.get(nums[i]);
                break;
            }
            m.put(target - nums[i], i);
        }
        return res;
    }
}
