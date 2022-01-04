import java.util.*;
/*
Sort array, for every unique num, run two sum using two pointers on the rest of elements
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length - 2 && nums[i] <= 0; ++i) {
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            twoPointerSum(nums, i, res);
        }
        return res;
    }
    
    private void twoPointerSum(int[] nums, int i, List<List<Integer>> res) {
        int l = i + 1, r = nums.length - 1;
        while(l < r) {
            int sum = nums[i] + nums[l] + nums[r];
            if(sum > 0) --r; 
            else if(sum < 0) ++l;
            else {
                res.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
                while(l < r && nums[l] == nums[l - 1]) ++l;
            }
        }
    }
}
