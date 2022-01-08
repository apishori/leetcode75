/*
dp: keep track of of running max and min as you go across array.
*/
class Solution {
    public int maxProduct(int[] nums) {
        int currMax = nums[0], currMin = nums[0], res = nums[0];
        for(int i = 1; i < nums.length; ++i) {
            int tempMax = Math.max(nums[i], Math.max(nums[i] * currMax, nums[i] * currMin));
            currMin = Math.min(nums[i], Math.min(nums[i] * currMax, nums[i] * currMin));
            currMax = tempMax;
            res = Math.max(res, currMax);
        }
        return res;
    }
}